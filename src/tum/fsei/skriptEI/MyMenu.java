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
		//Skript skript = new Skript(1,"title",0.5,"ident",50,false);
		//InternalStorage.vec.add(skript);
		
		System.out.print("IS länge: |" + InternalStorage.vec.size() + "|\n");
		
		int tmpID = InternalStorage.vec.elementAt(1).getId();
		double tmpPrice = InternalStorage.vec.elementAt(0).getPrice();
		String tmpTitle = InternalStorage.vec.elementAt(0).getTitle();
		tv.setText("Vector Size:" + InternalStorage.vec.size() + "Properties:" +tmpID + " " + tmpPrice + " " + tmpTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

}
