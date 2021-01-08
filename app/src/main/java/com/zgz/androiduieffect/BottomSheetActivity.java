package com.zgz.androiduieffect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.zgz.androiduieffect.adapter.DemoAdapter;
import com.zgz.androiduieffect.bean.DemoData;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: Bottom Sheet 作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/4 下午2:11
 * @Version: 1.0
 */
public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2;
    private TextView tvTest;
    private RelativeLayout nestedScrollView;
    private CoordinatorLayout clRoot;
    private RecyclerView recyclerView;
    private BottomSheetBehavior<RelativeLayout> behavior;
    private List<DemoData> list;
    private DemoAdapter demoAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        btn1 = findViewById(R.id.activity_bottom_sheet_btn1);
        btn2 = findViewById(R.id.activity_bottom_sheet_btn2);
        recyclerView = findViewById(R.id.activity_bottom_sheet_recycler_view);
        nestedScrollView = findViewById(R.id.bottom_sheet);
        clRoot = findViewById(R.id.activity_bottom_sheet_cl_root);
        behavior = BottomSheetBehavior.from(nestedScrollView);
        tvTest = findViewById(R.id.tv_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        initData();
        initAdapter();
        initBottomViewParam();
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //判断其状态
                if(newState==BottomSheetBehavior.STATE_EXPANDED){

                }else if(newState==BottomSheetBehavior.STATE_COLLAPSED){

                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.e("zhouguihzi","slideOffset: " + slideOffset);
            }
        });
    }

    private void initBottomViewParam() {
//        final ViewGroup.LayoutParams params = tvTest.getLayoutParams();
//        params.height = 300;
//        tvTest.setLayoutParams(params);

        clRoot.post(new Runnable() {
            @Override
            public void run() {
               int rootH = clRoot.getHeight();
                final ViewGroup.LayoutParams params  = nestedScrollView.getLayoutParams();
                params.height = rootH-300;
                nestedScrollView.setLayoutParams(params);
            }
        });
    }

    private void initAdapter() {
        demoAdapter = new DemoAdapter(list);
        recyclerView.setAdapter(demoAdapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(new DemoData("test--"+i));
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_bottom_sheet_btn1:
                setBottomSheetState();
                break;
            case R.id.activity_bottom_sheet_btn2:
                break;
        }
    }
    public void setBottomSheetState(){
        if(behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
