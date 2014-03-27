package tum.fsei.skriptEI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.IntentService;
import android.content.Intent;

public class DBService extends IntentService {
	public DBService() {
		super("HelloIntentService");
	}
	private String Liste = "";
	private String seperator = "##";

	/**
	 * A constructor is required, and must call the super IntentService(String)
	 * constructor with a name for the worker thread.
	 */

	/**
	 * The IntentService calls this method from the default worker thread with
	 * the intent that started the service. When this method returns,
	 * IntentService stops the service, as appropriate.
	 */

	@Override
	protected void onHandleIntent(Intent intent) {
		System.out.println("Service gestartet");

		try {
			URL url = new URL("http://www.fs.ei.tum.de/proxy/list_skripte_yaml");
		    BufferedReader in = new BufferedReader(
		                new InputStreamReader(
		                url.openStream()));

		    String inputLine;

		    while ((inputLine = in.readLine()) != null)
		    	// add inputLine to List
		    	Liste += inputLine + seperator; 
		        //System.out.println(Liste);

		    in.close();
		    
			parse_list(Liste);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		// Normally we would do some work here, like download a file.
		// For our sample, we just sleep for 5 seconds.
		long endTime = System.currentTimeMillis() + 1 * 1000;
		while (System.currentTimeMillis() < endTime) {
			synchronized (this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (Exception e) {
				}
			}
		}
	}
	
	/************************
	 *      UTF 8 Decode    *
	 ************************/
	
	private String replaceChar(String Liste)
	{
		Liste = Liste.replace("\\xC3\\xA4", "ä");
		Liste = Liste.replace("\\xC3\\x84", "Ä");
		Liste = Liste.replace("\\xC3\\xB6", "ö");
		Liste = Liste.replace("\\xC3\\x96", "Ö");
		Liste = Liste.replace("\\xC3\\xBC", "ü");
		Liste = Liste.replace("\\xC3\\x9C", "Ü");
		Liste = Liste.replace("\\xC3\\x9F", "ß");
		Liste = Liste.replace("\"", "");
		
		return Liste;
	}

	/************************
	 *       FileParser     *
	 ************************/
	public void parse_list(String Liste) {

		Skript mySkript = new Skript(0, null, 0, null, 0, false);
		String[] singleSkriptArray;
		String[] skriptArray;
		
		// Remove the first characters of the string
		Liste = Liste.substring(7);
		
		// Replace wrong decoded Chars
		Liste = replaceChar(Liste);
		
		// print list
		//System.out.print("Liste: |" + Liste + "|\n");
		
		// split the list in several scripts
		skriptArray = Liste.split(seperator +"-");
		//System.out.print("Lenght: |" + skriptArray.length + "|\n");
		
		// go through all Scripts
		for (String item : skriptArray) {
			// Set default values for next script
			mySkript.setId(-1); mySkript.setTitle(null); mySkript.setStock(0); mySkript.setPrice(0); mySkript.setIdent(null);
			
			// split all Scripts by their properties
			singleSkriptArray = item.split(seperator);
			for(String property : singleSkriptArray){
				if(property.indexOf("id:") > -1){ 				// ID
					mySkript.setId(Integer.parseInt(property.substring(property.indexOf("id:")+4)));	
				}
				else if (property.indexOf("title:") > -1){		// TITLE
					mySkript.setTitle(property.substring(property.indexOf("title:")+7));
				}
				else if (property.indexOf("stock:") > -1){		// STOCK
					mySkript.setStock(Integer.parseInt(property.substring(property.indexOf("stock:")+7)));
				}
				else if (property.indexOf("price:") > -1){		// PRICE
					mySkript.setPrice(Double.parseDouble(property.substring(property.indexOf("price:")+7)));
				}
				else if (property.indexOf("identifier:") > -1){	//IDENTIFIER
					mySkript.setIdent(property.substring(property.indexOf("identifier:")+12));
				}
			}
			
			// print Script Properties
			System.out.print("Id: |" + mySkript.getId() + "|\n");
			System.out.print("Title: |" + mySkript.getTitle() + "|\n");
			System.out.print("Price: |" + mySkript.getPrice() + "|\n");
			System.out.print("Stock: |" + mySkript.getStock() + "|\n");
			System.out.print("Ident: |" + mySkript.getIdent() + "|\n");
			
			// Check ID
			if(mySkript.getId() > -1)
			// Save mySkript in Internal Storage
			InternalStorage.setSkript(new Skript(	mySkript.getId(),
													mySkript.getTitle(), 
													mySkript.getPrice(), 
													mySkript.getIdent(), 
													mySkript.getStock(), 
													false));
			
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		 Intent dialogIntent = new Intent(getBaseContext(), tum.fsei.skriptEI.MyMenu.class);
		 //dialogIntent.putExtra("Storage", "bla");
		 dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 getApplication().startActivity(dialogIntent);
		 
		 

	}
}
