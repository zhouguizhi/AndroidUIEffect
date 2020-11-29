package com.zgz.androiduieffect.widget;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/**
 * @Description: 绘制圆形
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/29 下午10:17
 * @Version: 1.0
 */
public class CustomCircleView extends View implements View.OnClickListener {
    private Paint paint;
    private boolean isFill;
    private int mStrokeWidth = 6;
    public CustomCircleView(Context context) {
        this(context,null);
    }
    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(mStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        setOnClickListener(this);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int cx = Math.min(width/2,height/2);
        int cy = Math.min(width/2,height/2);
        int radius = Math.min(width/2-mStrokeWidth,height/2-mStrokeWidth);
        canvas.drawCircle(cx,cy,radius,paint);
    }
    @Override
    public void onClick(View view) {
        isFill = !isFill;
        paint.setStyle(isFill? Paint.Style.FILL: Paint.Style.STROKE);
        invalidate();
    }
}
