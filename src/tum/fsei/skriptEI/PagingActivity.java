package tum.fsei.skriptEI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class PagingActivity extends FragmentActivity {
	public ViewPager pager; 
	
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_paging);     

	        this.pager = (ViewPager) findViewById(R.id.viewPager);
	        this.pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
	    }

	    private class MyPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener  {

	        public MyPagerAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public Fragment getItem(int pos) {
	            switch(pos) {

	            case 0: return PageOneFragment.newInstance("FirstFragment, Instance 1");
	            //case 1: return PageOneFragment.newInstance("SecondFragment, Instance 1");
	            //case 2: return PageOneFragment.newInstance("ThirdFragment, Instance 1");
	            case 1: return new StandardListFragment();
	            case 2: return new SkriptListFragment();
	            case 3: return WishListPageFragment.newInstance("Last Page: Wishlist");
//	            case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
	            default: return PageOneFragment.newInstance("ThirdFragment, Default");
	            }
	        }

	        @Override
	        public int getCount() {
	            return 4;
	        }  
	        
	        @Override
	        public void onPageSelected(int i) {
	            Log.d("Seite", "Seite: " + i);
	        }

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public int getItemPosition(Object object)
			{
				return -2;
			}
	        
	    }
}
