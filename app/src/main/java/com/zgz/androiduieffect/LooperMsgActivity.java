package com.zgz.androiduieffect;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.zgz.androiduieffect.widget.LooperTextView;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 轮播图 消息
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/30 下午9:58
 * @Version: 1.0
 */
public class LooperMsgActivity extends AppCompatActivity {
    private int mIndex;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_msg);
        final LooperTextView looperTextView = findViewById(R.id.loop_msg);
        looperTextView.setTipList(generateTips());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mIndex++;
                looperTextView.setTipList(generateTips());
            }
        },5000);
    }
    private List<String> generateTips() {
        List<String> tips = new ArrayList<>();
        tips.add("赵丽颖-"+mIndex);
        tips.add("杨颖-"+mIndex);
        tips.add("郑爽-"+mIndex);
        tips.add("杨幂-"+mIndex);
        tips.add("刘诗诗-"+mIndex);
        tips.add("迪丽热巴-"+mIndex);
        tips.add("李沁-"+mIndex);
        tips.add("唐嫣-"+mIndex);
        tips.add("林心如-"+mIndex);
        tips.add("陈乔恩-"+mIndex);
        tips.add("范冰冰-"+mIndex);
        tips.add("刘亦菲-"+mIndex);
        tips.add("李小璐-"+mIndex);
        tips.add("佟丽娅-"+mIndex);
        return tips;
    }

}
