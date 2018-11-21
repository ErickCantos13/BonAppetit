package ca.humber.bonappetit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class proteinTab extends Fragment {
    // Initialize variables for ListView
    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_protein, container, false);

        listView=(ListView)view.findViewById(R.id.lv);
        textView=(TextView)view.findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_protein);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        return view;

    }

}
