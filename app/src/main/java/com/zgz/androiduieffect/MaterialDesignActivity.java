package com.zgz.androiduieffect;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @Description: Material Design相关
 * @Author: zhouguizhi
 * @CreateDate: 2020/12/23 上午10:09
 * @Version: 1.0
 */
public class MaterialDesignActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
    }

    public void OnElevationAttrActivity(View view) {
        startActivity(new Intent(this,ElevationAttrActivity.class));
    }
}
