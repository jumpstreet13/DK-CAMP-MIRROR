package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class CustomButton extends Button {

    private Paint paint;

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){
        paint = new Paint();
        paint.setAlpha(25);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(getPaddingLeft(), this.getMeasuredHeight()/1.2f, 380,this.getMeasuredHeight()/1.2f,paint);
    }
}
