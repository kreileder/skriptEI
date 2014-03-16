package tum.fsei.skriptEI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DBService extends IntentService {
	public DBService() {
		super("HelloIntentService");
	}

	private static final String LOG_TAG = "DBService";

	// Für die Loadfunktion
	private static final String TAG = DBService.class.getSimpleName();
	private static final String FILENAME = TAG + ".txt";
	private Vector<Skript> vec = new Vector<Skript>();

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
		InputStream is = null;

		try {
			URL url = new URL("http://www.fs.ei.tum.de/proxy/list_skripte_yaml");
			is = url.openStream();
			save(new Scanner(is).useDelimiter("\\Z").next());
			// skripte = new Scanner( is ).useDelimiter( "\\Z" ).next();
			// System.out.println(skripte);
			parse_list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
			}
		}

		// Log.v(LOG_TAG, skriptL.load());

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
	 *      FileWriter      *
	 ************************/
	public void save(String s) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = openFileOutput(FILENAME, MODE_PRIVATE);
			osw = new OutputStreamWriter(fos);
			osw.write(s);
		} catch (Throwable t) {
			// FileNotFoundException, IOException
			Log.e(TAG, "save()", t);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					Log.e(TAG, "osw.close()", e);
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					Log.e(TAG, "fos.close()", e);
				}
			}
		}
	}

	/************************
	 *      FileLoader      *
	 ************************/
	public String load() {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = openFileInput(FILENAME);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String s;
			// Datei zeilenweise lesen
			while ((s = br.readLine()) != null) {
				// ggf. Zeilenumbruch hinzufï¿½gen
				if (sb.length() > 0) {
					sb.append('\n');
				}
				sb.append(s);
			}
		} catch (Throwable t) {
			// FileNotFoundException, IOException
			Log.e(TAG, "load()", t);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					Log.e(TAG, "br.close()", e);
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					Log.e(TAG, "isr.close()", e);
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					Log.e(TAG, "fis.close()", e);
				}
			}
		}
		return sb.toString();
	}

	/************************
	 *       FileParser     *
	 ************************/
	public void parse_list() {

		Skript mySkript = new Skript(0, null, 0, null, 0, false);
		String[] singleSkriptArray;
		String list = "";
		String[] skriptArray;

		// Save the whole list in the variable list
		list = load();
		
		// Remove the first characters of the string
		list = list.substring(7);
		
		// print list
		//System.out.print("Liste: |" + list + "|\n");
		
		// split the list in several scripts
		skriptArray = list.split("- ");

		// go through all Scripts
		for (String item : skriptArray) {
			// Set default values for next script
			mySkript.setId(-1); mySkript.setTitle(null); mySkript.setStock(0); mySkript.setPrice(0); mySkript.setIdent(null);
			
			// split all Scripts by their properties
			singleSkriptArray = item.split("\\r?\\n");
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
		// Add Dummy Skript
		//mySkript.setId(500); mySkript.setTitle("Der Titel"); mySkript.setStock(20); mySkript.setPrice(7.4); mySkript.setIdent("#EI456");
		// Save mySkript in Internal Storage
		//InternalStorage.setSkript(mySkript);
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
