package tum.fsei.skriptEI;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class SkriptListFragment extends ListFragment {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.title_fragment_all_list);
        
        SkriptAdapter adapter = new SkriptAdapter();
        setListAdapter(adapter);
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
            double price = s.getPrice();
            String priceString = "Kostet: " + price;
            
            priceTextView.setText(priceString);
            CheckBox solvedCheckBox =
                (CheckBox)convertView.findViewById(R.id.checkBox);
            solvedCheckBox.setChecked(s.getSelected());

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
    }
	
//	@Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        Skript c = (Skript)(getListAdapter()).getItem(position);
//        //Log.d(TAG, c.getTitle() + " was clicked");
//    }
	
    
}
