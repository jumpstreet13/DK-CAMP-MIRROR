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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends DialogFragment {
    List<String> list;
    @BindView(R.id.list_in_spinner_layout) ListView listView;
    @OnClick(R.id.textView_in_spinner_layout)
    void onClik(){
        dismiss();
    }

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
        ButterKnife.bind(this, view);
        if(list != null) listView.setAdapter(new SpinnerAdapter(list, view.getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
