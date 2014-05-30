package tum.fsei.skriptEI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SkriptListFragment extends ListFragment {

	private CheckBox box;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.title_fragment_all_list);
        
        SkriptAdapter adapter = new SkriptAdapter();
        setListAdapter(adapter);
    }
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        
		SkriptAdapter adapter = new SkriptAdapter();
        setListAdapter(adapter);
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
	
	public void onResume()
	{
		super.onResume();
		Log.d("Resume", "Resume was called");
//		SkriptAdapter adapter = new SkriptAdapter();
//        setListAdapter(adapter);
		
	}
	
	
	/*
	 * Adapter für ListView
	 * 
	 */
	private class SkriptAdapter extends BaseAdapter {

        public SkriptAdapter() {
            //super(getActivity(), 0, skripte);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        	final int pos = position;
        	
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                    .inflate(R.layout.fragment_page_three, null);
            }

            // Configure the view for this Crime
            Skript s = InternalStorage.vec.get(position);

            TextView titleTextView =
                (TextView)convertView.findViewById(R.id.Name);
            titleTextView.setText(s.getTitle());
            
            TextView priceTextView =
                (TextView)convertView.findViewById(R.id.Price);
            float price = s.getPrice();
            String priceString = "Kostet: " + price + " � ";
            priceTextView.setText(priceString);
            
            TextView stockTextView =
                    (TextView)convertView.findViewById(R.id.Stock);
            int stock = s.getStock();
            if (stock <= 0){
            	stock = 0;
            	stockTextView.setTextColor(Color.RED);
            }
            else if (stock < 6){
            	stockTextView.setTextColor(Color.rgb(254, 184, 0));
            }
            else{
            	stockTextView.setTextColor(Color.BLACK);
            }
            String stockString = "Verf�gbar: " + stock + " St�ck";
            stockTextView.setText(stockString);
            
//            CheckBox solvedCheckBox =
//                (CheckBox)convertView.findViewById(R.id.checkBox);
//            solvedCheckBox.setChecked(s.getSelected());
            box = (CheckBox) convertView.findViewById(R.id.checkBox);
            box.setChecked(s.getSelected());
            box.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                	//
                	//	isChecked mirrors the state of the box, after the change happens
                	//
                	
                	if(isChecked == true)
                	{
                		//
                		//	Is currently checked, therefore should be unchecked now
                		//
                		Toast.makeText(getActivity(), "Select this" + pos, Toast.LENGTH_SHORT).show();
                		
                		InternalStorage.vec.elementAt(pos).setSelected(true);
                		
                		
                	}
                	else
                	{
                		Toast.makeText(getActivity(), "Unselect this", Toast.LENGTH_SHORT).show();
                		InternalStorage.vec.elementAt(pos).setSelected(false);
                	}
                	

                }
            });

            return convertView;
        }

		@Override
		public int getCount() {
		
			return InternalStorage.vec.size();
		}

		@Override
		public Skript getItem(int position) {
			// TODO Auto-generated method stub
			return InternalStorage.vec.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public int getItemPosition(Object object)
		{
			return -2;
		}
		
		
		
    }
	
//	@Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        Skript c = (Skript)(getListAdapter()).getItem(position);
//        //Log.d(TAG, c.getTitle() + " was clicked");
//    }
	
    
}
