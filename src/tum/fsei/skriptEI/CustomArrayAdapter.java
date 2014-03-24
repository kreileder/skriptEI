package tum.fsei.skriptEI;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] subjects;
    private final Integer[] imageIds;

    public CustomArrayAdapter(Activity context, 
    String[] subjects, Integer[] imageIds) {
        super(context, R.layout.lvrowlayout2, subjects);
        this.context = context;
        this.subjects = subjects;
        this.imageIds = imageIds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {     
        //---print the index of the row to examine---
        Log.d("CustomArrayAdapter",String.valueOf(position));

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.lvrowlayout2, null, true);

        //---get a reference to all the views on the xml layout---
        TextView txtTitle = (TextView) rowView.findViewById(R.id.subject); 
        TextView txtDescription = (TextView) rowView.findViewById(R.id.Description); 
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        //---customize the content of each row based on position---
        txtTitle.setText(subjects[position]);
        txtDescription.setText(								"Preis: " + 
        		   InternalStorage.vec.elementAt(position).getPrice() + 
        		   										 " Bestand: " +
        		   InternalStorage.vec.elementAt(position).getStock()
        					   );
        
        imageView.setImageResource(imageIds[position]);
        return rowView;
    }
}

