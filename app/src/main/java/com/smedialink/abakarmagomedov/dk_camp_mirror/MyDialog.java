package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyDialog extends android.support.v7.app.AlertDialog {

    private int layout, positive, negative;
    private MyDialogListener listener;

   public interface MyDialogListener{
        void onPositive();
        void onNegative();
    }

    public MyDialog(Context context, int layout, int positive, int negative, final MyDialogListener listener) {
        super(context);
        this.layout = layout;
        this.listener = listener;
        this.positive = positive;
        this.negative = negative;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.layout);
        ButterKnife.bind(this);
        Button button = (Button)findViewById(positive);
        Button button1 = (Button)findViewById(negative);
        if(button!=null && button1 != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPositive();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNegative();
                }
            });
        }
    }
}
