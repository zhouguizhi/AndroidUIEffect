package com.zgz.androiduieffect.widget;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zgz.androiduieffect.util.DisplayUtil;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/30 下午9:38
 * @Version: 1.0
 */
public  class TaiJiView extends View {
    private int width = DisplayUtil.dp2px(getContext(),200);
    private int height = DisplayUtil.dp2px(getContext(),200);
    private int padding = 5;
    private Paint mPaint;
    private RectF mRectf;

    public TaiJiView(Context context) {
        this(context,null);
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }
    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width,height);
        mRectf = new RectF(0,0,width,width);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCirCle(canvas);
        drawHalfCirCle(canvas);
        drawSmallCircle(canvas);
    }
    /**
     * 画一个简单的圆
     * @param canvas
     */
    private void drawCirCle(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawArc(mRectf,270,180,true,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(mRectf,270,-180,true,mPaint);
    }
    private void drawHalfCirCle(Canvas canvas) {
        //画上面黑色半圆
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        RectF blackHalfRect = new RectF(width/4,0,width/2+width/4,width/2);
        canvas.drawArc(blackHalfRect,270,180,true,mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        RectF whiteHalfRect = new RectF(width/4,width/2,width/2+width/4,width);
        canvas.drawArc(whiteHalfRect,270,-180,true,mPaint);
    }
    /**
     * 绘制二个小圆点
     * @param canvas
     */
    private void drawSmallCircle(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2,width/4,20,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2,width/4*3,20,mPaint);
    }
}
