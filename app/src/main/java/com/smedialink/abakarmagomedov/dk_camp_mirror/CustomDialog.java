package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.dk_camp_mirror.models.SpinnerAdapter;

import java.util.List;

public class CustomDialog extends DialogFragment {
    List<String> list;

    public CustomDialog(){

    }

    public static CustomDialog newInstance(){
        return new CustomDialog();
    }

    public void setList(List<String> list){
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spinner_layout, container);
        TextView textView = (TextView)view.findViewById(R.id.textView_in_spinner_layout);
        // TODO: 09.03.17 Butterknife
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        ListView listView = (ListView)view.findViewById(R.id.list_in_spinner_layout);
        if(list != null) listView.setAdapter(new SpinnerAdapter(list, view.getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

}
