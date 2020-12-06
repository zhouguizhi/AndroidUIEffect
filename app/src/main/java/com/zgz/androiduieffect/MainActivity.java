package com.zgz.androiduieffect;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickBaseViewListener(View view) {
        startActivity(new Intent(this,DrawBaseViewActivity.class));
    }

    public void onClickTaijiViewListener(View view) {
        startActivity(new Intent(this,TaiJiActivity.class));
    }

    public void OnLopperViewListener(View view) {
        startActivity(new Intent(this,LooperMsgActivity.class));
    }

    public void OnTestConstraintListener(View view) {
        startActivity(new Intent(this,TestConstraintActivity.class));
    }

    public void OnTestAnimListener(View view) {
        startActivity(new Intent(this,TestAnimActivity.class));
    }
}