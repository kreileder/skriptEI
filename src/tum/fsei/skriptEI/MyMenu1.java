package tum.fsei.skriptEI;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.ListView;

public class MyMenu1 extends Activity {
	
		ListView listView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_menu1);
		
		 MyPageAdapter adapter = new MyPageAdapter();
			ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
			viewPager.setAdapter(adapter);

			
			
			
			viewPager.setCurrentItem(0);
			
			//Begin changes
			//listView = (ListView) findViewById(R.id.);
			// End changes
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu1, menu);
		return true;
	}

}
