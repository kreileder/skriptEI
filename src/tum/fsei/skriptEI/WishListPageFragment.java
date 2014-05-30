package tum.fsei.skriptEI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        TextView textViewCaution = (TextView) v.findViewById(R.id.textViewCaution);
        ImageView imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        
        float sumPrice = 0;
        int stock = 0;
        float price = 0;
        String title = "";
        boolean caution = false;
        
        for(int i = 0; i < InternalStorage.vec.size(); i++)
        {
        	//
        	//	Add all selected scripts
        	//
        	if(InternalStorage.vec.elementAt(i).getSelected())
        	{	
        		title = InternalStorage.vec.elementAt(i).getTitle();
        		stock = InternalStorage.vec.elementAt(i).getStock();
        		if (stock <= 0){
        			stock = 0;
        			caution = true;
        			
        		}
        		price = InternalStorage.vec.elementAt(i).getPrice();
        		
        		selectedSkripte += title + "\n";
        		selectedSkripte += "Verfügbar: " + stock + "  |  Preis: " + price +" €\n";
        		selectedSkripte += "\n";
        		sumPrice 		+= InternalStorage.vec.elementAt(i).getPrice();
        	}
        }
        
        selectionView.setText(selectedSkripte);
        textViewPrice.setText("Gesamtpreis: " + sumPrice + " €");
        
        if (caution){
        	textViewCaution.setText("Es sind nicht alle Skripte verfügbar!");
        	imageView1.setImageResource(R.drawable.danger);
        }
        else{
        	textViewCaution.setText("Alle Skripte sind vorätig!");
        	imageView1.setImageResource(R.drawable.ok);
        }
        	
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
