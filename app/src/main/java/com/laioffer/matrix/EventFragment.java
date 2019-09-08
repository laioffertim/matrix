package com.laioffer.matrix;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    private ListView listView;
    OnItemSelectListener callBack;

    // Container Activity must implement this interface
    public interface OnItemSelectListener {
        void onItemSelected(int position);
    }


    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callBack = (OnItemSelectListener) context;
        } catch (ClassCastException e) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        listView = view.findViewById(R.id.event_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getEventNames());

        // Assign adapter to ListView.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callBack.onItemSelected(position);
            }
        });
        return view;
    }

    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }

    public void onItemSelected(int position){
        for (int i = 0; i < listView.getChildCount(); i++){
            if (position == i) {
                listView.getChildAt(i).setBackgroundColor(Color.BLUE);
            } else {
                listView.getChildAt(i).setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

    }
}
