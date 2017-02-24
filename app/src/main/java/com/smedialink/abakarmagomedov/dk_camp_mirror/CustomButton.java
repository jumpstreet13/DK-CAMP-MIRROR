package com.smedialink.abakarmagomedov.dk_camp_mirror;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class CustomButton extends Button {

    private Paint paint;
    private boolean isBottom;

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    void init(){
        paint = new Paint();
        paint.setAlpha(25);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(6);
    }

    void init(Context context, AttributeSet attrs, int defStyle){
        init();
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomButton,0,0);
        isBottom = styledAttributes.getBoolean(R.styleable.CustomButton_whereDrawLine, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = 350;
        if(!isBottom) {canvas.drawLine(getPaddingLeft(), this.getMeasuredHeight()*0.1f, length,this.getMeasuredHeight()*0.1f,paint);}
        if(isBottom) {canvas.drawLine(getPaddingLeft(), this.getMeasuredHeight()/1.4f, length,this.getMeasuredHeight()/1.4f,paint);}
    }
}
