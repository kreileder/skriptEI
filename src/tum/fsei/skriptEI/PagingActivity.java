package tum.fsei.skriptEI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class PagingActivity extends FragmentActivity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_paging);     

	        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
	        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	    }

	    private class MyPagerAdapter extends FragmentPagerAdapter {

	        public MyPagerAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public Fragment getItem(int pos) {
	            switch(pos) {

	            case 0: return PageOneFragment.newInstance("FirstFragment, Instance 1");
	            case 1: return PageOneFragment.newInstance("SecondFragment, Instance 1");
	            case 2: return PageOneFragment.newInstance("ThirdFragment, Instance 1");
	            case 3: return new StandardListFragment();
//	            case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
//	            case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
	            default: return PageOneFragment.newInstance("ThirdFragment, Default");
	            }
	        }

	        @Override
	        public int getCount() {
	            return 4;
	        }       
	    }
}
