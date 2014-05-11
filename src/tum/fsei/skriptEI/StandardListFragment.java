package tum.fsei.skriptEI;
import tum.fsei.skriptEI.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;


public class StandardListFragment extends ListFragment {

	String[] standardPacks = {"1.Semester","2.Semester","3.Semester","4.Semester"};
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        getActivity().setTitle(R.string.title_fragment_standard_list);
	    
	
	        ArrayAdapter<String> adapter =
	           new ArrayAdapter<String>(getActivity(),
	                                   android.R.layout.simple_list_item_1,
	                                   standardPacks);
	        setListAdapter(adapter);
	 }
}
