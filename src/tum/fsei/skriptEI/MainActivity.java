package tum.fsei.skriptEI;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public final String PREFS_NAME = "SkriptStorage";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * begin dialog
		 * Very important
		 */
		ContextWrapper myCtxt = new ContextWrapper(this);
        AlertDialog.Builder startDialog = new AlertDialog.Builder(myCtxt);
        //TODO Strings in res/values/strings auslagern
        startDialog.setMessage("Verbinden zum Fachschaftsserver um den aktuellen Skriptenbestand zu erhalten ?");
        startDialog.setPositiveButton("Ja", new
                DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,
                int whichButton)
                {
                    
                    
                    //Intent intent = new Intent(this,DBService.class);
            		Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.DBService.class);
                    startService(intent);
                    
                    Toast.makeText(getBaseContext(),
                            "Den Service starten!", Toast.LENGTH_SHORT).show();
                    
                    //Intent intent1 = new Intent(getBaseContext(), tum.fsei.skriptEI.MyMenu.class);
                    //startActivity(intent1);
                    
                    
                }
            });
        
        startDialog.setNegativeButton("Nein", new
                DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,
                    int whichButton)
                {
                    Toast.makeText(getBaseContext(),
                            "Letzten Stand aus dem Handyspeicher entnehmen!!!", Toast.LENGTH_LONG).show();
                    
                    SharedPreferences storage = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    restore.load(storage);
            		
                    Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.MyMenu.class);
                    startActivity(intent);

                }
            });
        
        startDialog.show();
		/*
		 * end dialog
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
	 protected void onDestroy(){
		 super.onDestroy();
		 SharedPreferences storage = getSharedPreferences(PREFS_NAME, 0);
		 
	     restore.save(storage);
	      
	 }
	
	

}
