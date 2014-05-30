package tum.fsei.skriptEI;

import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageOneFragment extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_one, container, false);
        
        TextView tv = (TextView) v.findViewById(R.id.Date);
        tv.setText("Version: 30.03.2014");

        return v;
    }

    public static PageOneFragment newInstance(String text) {

    	PageOneFragment f = new PageOneFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
