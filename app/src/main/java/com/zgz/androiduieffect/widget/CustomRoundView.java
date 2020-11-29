package com.zgz.androiduieffect.widget;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/**
 * @Description: 绘制圆角
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/29 下午10:17
 * @Version: 1.0
 */
public class CustomRoundView extends View{
    private Paint paint;
    private int mStrokeWidth = 6;
    public CustomRoundView(Context context) {
        this(context,null);
    }
    public CustomRoundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomRoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(mStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        RectF rectF = new RectF(0, 0, width, height);
        canvas.drawRoundRect(rectF,20,20,paint);
    }
}
