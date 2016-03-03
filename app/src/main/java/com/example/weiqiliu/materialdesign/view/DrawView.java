package com.example.weiqiliu.materialdesign.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.weiqiliu.materialdesign.R;

public class DrawView extends View implements View.OnClickListener{
    private int backgroundColor;
    private int mRadius;
    private int sRadius;
    private Paint mPaint;
    private float deltaX;
    private float deltaY;
    private int width;
    private int height;
    private boolean firstLoading=true;

    public DrawView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public DrawView(Context context)
    {
        this(context, null);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DrawView, defStyle, 0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = typedArray.getIndex(i);
            switch (attr)
            {
                case R.styleable.DrawView_backgroudColor:
                    backgroundColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.DrawView_radius:
                    mRadius= typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
                    break;
            }

        }
        typedArray.recycle();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        setOnClickListener(this);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(backgroundColor);
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);

        Paint mPaint2 = new Paint();
        sRadius=mRadius/4;
        mPaint2.setColor(Color.BLACK);
        if(firstLoading){
            canvas.drawCircle(mRadius-deltaX , mRadius-deltaY, sRadius, mPaint2);
        }else {
            canvas.drawCircle(deltaX, deltaY, sRadius, mPaint2);
        }
    }

//    @Override
//    protected void dispatchDraw(Canvas canvas) {
//        super.dispatchDraw(canvas);
//        Paint mPaint2 = new Paint();
//        mPaint2.setColor(Color.BLACK);
//        if(firstLoading){
//            canvas.drawCircle(mRadius-deltaX , mRadius-deltaY, mRadius / 4, mPaint2);
//        }else {
//            if(deltaX>0&&deltaY>0&&deltaX<width&&deltaY<height) {
//                canvas.drawCircle(deltaX, deltaY, mRadius / 4, mPaint2);
//            }
//        }
//    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            float widthCircle = mRadius * 2;
            int desired = (int) (getPaddingLeft() + widthCircle + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            float heightCircle = mRadius * 2;
            int desired = (int) (getPaddingTop() + heightCircle + getPaddingBottom());
            height = desired;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        firstLoading=false;
        deltaX = event.getX()>sRadius/2?event.getX():0;
        deltaY = event.getY()>sRadius/2?event.getY():0;
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("deltaX",String.valueOf(deltaX));
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.e("222","f反反复复");
    }

    //get and set method
    public int getmRadius() {
        return mRadius;
    }

    public void setmRadius(int mRadius) {
        this.mRadius = mRadius;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

}
