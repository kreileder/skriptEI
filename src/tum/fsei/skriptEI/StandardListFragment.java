package tum.fsei.skriptEI;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
	 
	 @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
	        //Crime c = (Crime)(getListAdapter()).getItem(position);
	        Log.d("StdLstFrgmt", position + " was clicked");
	        
	        //
	        //	Aktuell ist die Liste folgendermaßen aufgebaut:
	        //
	        //	1.Semester
	        //	2.Semester
	        //	3.Semester
	        //	4.Semester
	        //
	        //	Daher kann setPack einfach Position 
	        //	übergeben werden. 
	        //	TODO: Bessere Zuordnung finden!
	        //
	        SemesterPack skriptsToCheck = new SemesterPack();
	        //
	        //	position fängt bei Null an zu zählen
	        //
	        skriptsToCheck.setPack(position + 1);
	        
	        //
	        //	Alle Skripte dieser Kategorie im InternalStorage auswählen,
	        //	bzw. abwählen falls bereits ausgewäht.
	        //
	        for(int i = 0; i < skriptsToCheck.scripts.length; i++)
	        {
	        	String subjectToToggle = skriptsToCheck.scripts[i];
	        	//
	        	//	Den IntenalStorage nach dem subjectToToggle
	        	//	durchsuchen.
	        	//
	        	for(int j = 0; j < InternalStorage.vec.size(); j++)
	        	{
	        		// Falls die Identifier übereinstimmen den Zustand wechseln
	        		if( subjectToToggle.equals(InternalStorage.vec.elementAt(j).ident) )
	        		{
	        			if(InternalStorage.vec.elementAt(j).selected == false)
	        			{
	        				InternalStorage.vec.elementAt(j).selected = true;
	        			}
	        			else
	        			{
	        				InternalStorage.vec.elementAt(j).selected = false;
	        			}
	        			
	        		}
	        	}
	        }
	    }
}
