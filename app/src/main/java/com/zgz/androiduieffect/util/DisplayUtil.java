package com.zgz.androiduieffect.util;
import android.content.Context;
import android.util.TypedValue;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2020/11/30 下午9:48
 * @Version: 1.0
 */
public class DisplayUtil {
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
