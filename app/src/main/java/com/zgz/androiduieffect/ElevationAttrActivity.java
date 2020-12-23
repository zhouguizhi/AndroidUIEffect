package com.zgz.androiduieffect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @Description: android:elevation 属性使用,如果2个view有重叠的话,设置了android:elevation="20dp"那个大，那个view就在上面
 * 如果使用代码就是view.setTranslationZ(100f); 而且必现是在根布局的直接子view
 * @Author: zhouguizhi
 * @CreateDate: 2020/12/23 上午10:21
 * @Version: 1.0
 */
public class ElevationAttrActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevation);
    }

    public void onTestMethod1(View view) {
        Toast.makeText(this,"A",Toast.LENGTH_LONG).show();
    }
    public void onTestMethod2(View view) {
        Toast.makeText(this,"B",Toast.LENGTH_LONG).show();
    }
    public void onTestMethod3(View view) {
        Toast.makeText(this,"C",Toast.LENGTH_LONG).show();
    }
    public void onTestMethod4(View view) {
        Toast.makeText(this,"D",Toast.LENGTH_LONG).show();
    }
}
