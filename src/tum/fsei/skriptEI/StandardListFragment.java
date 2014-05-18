package tum.fsei.skriptEI;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


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
	        	Log.d("Skript:", subjectToToggle);
	        	Log.d("Skript:", "Erwartete Anzahl" + skriptsToCheck.scripts.length);
	        	
	        	// Count number of hits
	        	int hitCounter = 0;
	        	
	        	
	        	//Log.d("IS:", InternalStorage.vec.elementAt(1).getIdent());
	        	//
	        	//	Den IntenalStorage nach dem subjectToToggle
	        	//	durchsuchen.
	        	//
	        	for(int j = 0; j < InternalStorage.vec.size(); j++)
	        	{
	        		//
	        		//	Just for debugging
	        		//
	        		String currentSubject = InternalStorage.vec.elementAt(j).getIdent();
	        		Log.d("Aktuelles Skript:", currentSubject);
	        		
	        		
	        		
	        		// Falls die Identifier übereinstimmen den Zustand wechseln
	        		if( subjectToToggle.equals(InternalStorage.vec.elementAt(j).getIdent()) )
	        		{
	        			hitCounter = hitCounter + 1;
	        			Log.d("Skript:", "Trefferanzahl " + hitCounter);
	        			if(InternalStorage.vec.elementAt(j).getSelected() == false)
	        			{
	        				InternalStorage.vec.elementAt(j).setSelected(true);
	        			}
	        			else
	        			{
	        				InternalStorage.vec.elementAt(j).setSelected(false);
	        			}
	        			
	        		}
	        	}
	        }
	        ViewPager pager;
	        pager = (ViewPager) getActivity().findViewById(R.id.viewPager);
	        pager.getAdapter().notifyDataSetChanged();
	        Toast.makeText(getActivity(), "Data change", Toast.LENGTH_SHORT).show();
	    }
	 
}
