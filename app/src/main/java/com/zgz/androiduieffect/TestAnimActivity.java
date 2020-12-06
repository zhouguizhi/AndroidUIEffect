package com.zgz.androiduieffect;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anim);
        iv1 = findViewById(R.id.iv1);
        iv1.setOnClickListener(this);
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
    public void scaleY(){
        ObjectAnimator.ofFloat(iv1,"scaleY",0,200).start();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv1:
                translationXY();
                break;
        }
    }
}
