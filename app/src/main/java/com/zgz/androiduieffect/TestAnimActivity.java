package com.zgz.androiduieffect;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @Description: 属性动画
 * @Author: zhouguizhi
 * @CreateDate: 2020/12/3 下午9:19
 * @Version: 1.0
 */
public class TestAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv1;
    private ImageView iv2;
    private Button iv3;
    private ImageView iv4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anim);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv1.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
    }
    public void translationX(){
        ObjectAnimator.ofFloat(iv1,"translationX",0,200).start();
    }
    public void translationY(){
        ObjectAnimator.ofFloat(iv1,"translationY",0,200).start();
    }
    public void translationXY(){
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(iv1,"translationX",0,200);
        ObjectAnimator objectAnimatorY =  ObjectAnimator.ofFloat(iv1,"translationY",0,200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX,objectAnimatorY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
    public void scaleX(){
        ObjectAnimator.ofFloat(iv1,"scaleX",0,200).start();
    }
    public void scaleY(){
        ObjectAnimator.ofFloat(iv1,"scaleY",0,200).start();
    }
    public void scaleXY(){
        ObjectAnimator s1 = ObjectAnimator.ofFloat(iv1,"scaleY",1,1.2f);
        ObjectAnimator s2 = ObjectAnimator.ofFloat(iv1,"scaleX",1,1.2f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(s1,s2);
        animatorSet.setDuration(200);
        s1.setRepeatCount(10000);
        s2.setRepeatCount(10000);
        s1.setRepeatMode(ValueAnimator.REVERSE);
        s2.setRepeatMode(ValueAnimator.REVERSE);
        animatorSet.start();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv1:
                scaleXY();
                break;
            case R.id.iv2:
                tranX();
                break;
            case R.id.iv3:
                execAnimator();
                break;
            case R.id.iv4:
                tran4();
                break;
        }
    }
    public void tran4(){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(iv4, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(iv4, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(iv4, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }
    public void execAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(Color.parseColor("#000000"), Color.parseColor("#ffffff"));
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(5000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                iv3.setBackgroundColor(curValue);
            }
        });
    }
    private int left,top;
    private int tempValue = 0;
    private void tranX() {
        ValueAnimator animator = ValueAnimator.ofInt(0,100);
        animator.setDuration(1000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int)valueAnimator.getAnimatedValue();
                left = iv2.getLeft();
                top = iv2.getTop();
                iv2.layout(left+curValue-tempValue,top+curValue-tempValue,left+iv2.getWidth()+curValue-tempValue,iv2.getHeight()+curValue+top-tempValue);
                tempValue = curValue;
            }
        });

    }
}
