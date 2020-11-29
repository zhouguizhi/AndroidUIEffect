package com.zgz.androiduieffect.widget;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/**
 * @Description: 绘制三角形
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/29 下午10:04
 * @Version: 1.0
 */
public class CustomRriangleView extends View {
    private Paint paint;
    public CustomRriangleView(Context context) {
        this(context,null);
    }

    public CustomRriangleView(Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
    }

    public CustomRriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width  =  getMeasuredWidth();
        int height = getMeasuredHeight();
        canvas.drawLine(width/2,0,0,height,paint);
        canvas.drawLine(0,height,width,height,paint);
        canvas.drawLine(width,height,width/2,0,paint);
    }
    public void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
    }
}
