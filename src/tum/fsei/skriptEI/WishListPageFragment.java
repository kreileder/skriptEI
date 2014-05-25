package tum.fsei.skriptEI;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WishListPageFragment extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_wishlist, container, false);

        //
        //	Show the user selection
        //
        TextView selectionView = (TextView) v.findViewById(R.id.textViewSelection);
        String selectedSkripte = "";
        TextView textViewPrice = (TextView) v.findViewById(R.id.textViewPreis);
        float sumPrice = 0;
        
        for(int i = 0; i < InternalStorage.vec.size(); i++)
        {
        	//
        	//	Add all selected scripts
        	//
        	if(InternalStorage.vec.elementAt(i).getSelected())
        	{
        		selectedSkripte += InternalStorage.vec.elementAt(i).getTitle();
        		selectedSkripte += " \n";
        		sumPrice 		+= InternalStorage.vec.elementAt(i).getPrice();
        	}
        }
        
        selectionView.setText(selectedSkripte);
        textViewPrice.setText("Preis: " + sumPrice + "€");

        return v;
    }

    public static WishListPageFragment newInstance(String text) {

    	WishListPageFragment f = new WishListPageFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
