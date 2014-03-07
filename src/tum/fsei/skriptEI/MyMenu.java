package tum.fsei.skriptEI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MyMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_menu);
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		Skript skript 		= new Skript("id","title","price","ident","stock",false);
		InternalStorage.vec.add(skript);
		
		String tmpID = InternalStorage.vec.elementAt(0).getId();
		String tmpPrice = InternalStorage.vec.elementAt(0).getPrice();
		String tmpTitle = InternalStorage.vec.elementAt(0).getTitle();
		
		
		tv.setText(tmpID + " " + tmpPrice + " " + tmpTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

}
