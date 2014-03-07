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
	
	private static final String LOG_TAG = "MyActivity";
	
	//Für die Loadfunktion
	private static final String TAG = DBService.class.getSimpleName();
	private static final String FILENAME = TAG + ".txt";
	private static Vector<Skript> parsedSkript = new Vector<Skript>();
	
	// Klasse Skripenliste


	/** 
	 * A constructor is required, and must call the super IntentService(String)
	 * constructor with a name for the worker thread.
	 */
	 

	/**
	 * The IntentService calls this method from the default worker thread with
	 * the intent that started the service. When this method returns, IntentService
	 * stops the service, as appropriate.
	 */
	@Override
	protected void onHandleIntent(Intent intent) {

		
		Log.v(LOG_TAG,"IchBinDerService");
		System.out.println("ServiceOhneEnde");

		InputStream is = null;

		try{
			URL url = new URL( "http://www.fs.ei.tum.de/proxy/list_skripte_yaml" );
		    is = url.openStream();
		    //System.out.println( new Scanner( is ).useDelimiter( "\\Z" ).next() );
		    //Log.v(LOG_TAG, new Scanner( is ).useDelimiter( "\\Z" ).next() );
		    Log.v(LOG_TAG, "hier auch");
		    save(new Scanner( is ).useDelimiter( "\\Z" ).next());
		    Log.v(LOG_TAG, "Und hier");
		    //skripte = new Scanner( is ).useDelimiter( "\\Z" ).next();
		    //System.out.println(skripte);
		    parse_list();
		}
		catch ( Exception e ){
		    e.printStackTrace();
		}
		finally{
		    if ( is != null )
		      try { is.close(); } catch ( IOException e ) { }
		}
		    
		//Log.v(LOG_TAG, skriptL.load());

		// Normally we would do some work here, like download a file.
		// For our sample, we just sleep for 5 seconds.
		long endTime = System.currentTimeMillis() + 1*1000;
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
					// ggf. Zeilenumbruch hinzuf�gen
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
		 *      FileParser      *
		 ************************/
		public String parse_list(){
			
			int i = 0;
			int indexID;
			int indexTitle;
			int indexPrice;
			int indexIdent;
			int indexStock;
			int indexLoc;
			String list = "";
			String[] skriptArray;
			//Vector<skriptData> parsedSkript = new Vector<skriptData>(); 
			
			
			// Die Skripenliste in list speichern
			list = load();
			// Liste in einzellne Skripten trennen
			skriptArray  = list.split("- ");
			
			for (String item: skriptArray){
				
				// Findet die Indexliste
				indexID = item.indexOf("id:");
				indexTitle = item.indexOf("title:");
				indexPrice = item.indexOf("price:");
				indexIdent = item.indexOf("identifier:");
				indexStock = item.indexOf("stock:");
				indexLoc = item.indexOf("location:");
				
				//String id = indexID.toString;
				
				InternalStorage.setSkript(""+indexID+"", ""+indexTitle+"", ""+indexPrice+"", ""+indexIdent+"", ""+indexStock+"", false);
				
				System.out.print("ID: |"+indexID+"|\n");
				System.out.print("Title: |"+indexTitle+"|\n");
				System.out.print("Price: |"+indexPrice+"|\n");
				System.out.print("Idnet: |"+indexIdent+"|\n");
				System.out.print("Stock: |"+indexStock+"|\n");
				System.out.print("Loc: |"+indexLoc+"|\n");
				
				if(indexID > -1 && indexTitle > -1 && indexPrice > -1 && indexIdent > -1 && indexStock > -1){
					if(indexIdent < indexPrice && indexPrice < indexStock && indexStock < indexTitle && indexTitle < indexID){
						i = i+1;
						//System.out.print("Valid Skript NR:"+i+"\n");
						//System.out.print("ID:"+item.substring(indexID+4,indexTitle-3)+"|\n");
						//System.out.print("Title:"+item.substring(indexTitle+7,indexPrice-3)+"|\n");
						//System.out.print("Price:"+item.substring(indexPrice+7,indexIdent-3)+"|\n");
						//System.out.print("Ident:"+item.substring(indexIdent+12,indexStock-3)+"|\n");
						//System.out.print("Stock:"+item.substring(indexStock+7,item.length()-1)+"|\n");
						
						/*if(indexLoc > -1){
							Skript.setStock(item.substring(indexID+4,indexLoc-3));
						}
						else
						{
							Skript.setId(item.substring(indexID+4,item.length()-1));
						}
						
						Skript.setTitle(item.substring(indexTitle+7,indexID-3));
						Skript.setPrice(item.substring(indexPrice+7,indexStock-3));
						Skript.setIdent(item.substring(indexIdent+12,indexStock-3));
						Skript.setStock(item.substring(indexStock+7,indexTitle-3));
						
						// Zum Array hinzuf�gen
						parsedSkript.add(Skript);*/
						
						/*Skript.setId("125");
						Skript.setTitle("MyTitle");
						Skript.setPrice("der Prei�");
						Skript.setIdent("EI322");
						Skript.setStock("500");
						
						parsedSkript.add(Skript);*/
					}
					/*else
					{
						Skript.setId(item.substring(indexID+4,indexStock-3));
						Skript.setTitle(item.substring(indexTitle+7,indexID-3));
						Skript.setPrice(item.substring(indexPrice+7,indexIdent-3));
						Skript.setIdent(item.substring(indexIdent+12,indexTitle-3));
						if(indexLoc > -1){
							Skript.setStock(item.substring(indexStock+7,indexLoc-3));
						}
						else
						{
							Skript.setStock( item.substring(indexStock+7,item.length()-1));
						}
						
						// Zum Array hinzuf�gen
						parsedSkript.add(Skript);
					}*/
					
				}
			}
			//parser.setList(parsedSkript);
			
			
			
			//System.out.print("Skript nr 5:"+parsedSkript.get(5).getId());
			return "";
		
			
			
		}
		@Override
	    public void onDestroy(){
	       super.onDestroy();
	       
//	       Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.MyMenu.class);
//	       startActivity(intent);
	      
	    }
		
}
