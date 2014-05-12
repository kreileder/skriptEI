package tum.fsei.skriptEI;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_menu);
		
		Button myButton = (Button) findViewById(R.id.button1);
		myButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) 
		    {		    	
		    	Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.MyListView.class);
		    	startActivity(intent);
		    }
		});
		
		Button myButton2 = (Button) findViewById(R.id.button2);
		myButton2.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) 
		    {		    	
		    	Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.PagingActivity.class);
		    	startActivity(intent);
		    }
		});
		
		Button rssButton = (Button) findViewById(R.id.RSSButton);
		rssButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) 
		    {		    	
		    	Intent intent = new Intent(getBaseContext(), tum.fsei.skriptEI.RSSActivity.class);
		    	startActivity(intent);
		    }
		});
		
		//TextView tv = (TextView) findViewById(R.id.textView1);
		//Skript skript = new Skript(1,"title",0.5,"ident",50,false);
		//InternalStorage.setSkript(skript);
		
		//System.out.print("IS l�nge: |" + InternalStorage.vec.size() + "|\n");
		
		//int tmpID = InternalStorage.vec.elementAt(2).getId();
		//double tmpPrice = InternalStorage.vec.elementAt(2).getPrice();
		//String tmpTitle = InternalStorage.vec.elementAt(2).getTitle();
//		String myText = "";
//		int i = 0;
//		
//		for(Skript skript : InternalStorage.vec){
//			myText += "Nr: " + i + "\n";
//			myText += "ID: " + skript.getId() + "\n";
//			myText += "Titel: " + skript.getTitle() + "\n";
//			myText += "Preis: " + skript.getPrice() + "\n";
//			i = i + 1;
//		}
//		tv.setText(myText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

}
