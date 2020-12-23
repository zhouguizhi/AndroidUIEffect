package com.zgz.androiduieffect;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @Description: Paint类相关方法
 * @Author: zhouguizhi
 * @CreateDate: 2020/12/7 下午8:14
 * @Version: 1.0
 */
public class TestPaintActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_test_paint);
    }
    ///Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/bin
}
