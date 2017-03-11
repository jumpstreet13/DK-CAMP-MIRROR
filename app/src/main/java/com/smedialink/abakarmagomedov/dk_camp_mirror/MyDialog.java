package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MyDialog extends android.support.v7.app.AlertDialog {

    int layout, positive, negative;
    MyDialogListener listener;

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
        Button button = (Button)findViewById(positive);
        Button button1 = (Button)findViewById(negative);
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
