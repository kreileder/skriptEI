package tum.fsei.skriptEI;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MyListView extends ListActivity {

    Integer[] imageIDs = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9,
            R.drawable.pic10,
            R.drawable.pic11
    };

	String[] subjects = new String[ InternalStorage.vec.size() ];
	Integer[] myImageIDs = new Integer[ InternalStorage.vec.size() ];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        for(int i = 0; i<InternalStorage.vec.size(); i++)
        {
        	subjects[i] = InternalStorage.vec.elementAt(i).getTitle();
        	//myImageIDs[i] = InternalStorage.vec.elementAt(i).getId();
        }
        
        
        
        ListView lstView = getListView();
        //lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        //lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); 
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        
        setListAdapter(new ArrayAdapter<String>(this, 
        android.R.layout.simple_list_item_checked, subjects));
        
       // CustomArrayAdapter adapter = new CustomArrayAdapter(this, subjects, imageIDs);
       // setListAdapter(adapter);
        
    }

    public void onListItemClick(ListView parent, View v, 
    int position, long id) {
        CheckedTextView item = (CheckedTextView) v;
        Toast.makeText(this, subjects[position] + " ausgewaehlt : " + item.isChecked(), 
            Toast.LENGTH_SHORT).show();
    }
    
}
