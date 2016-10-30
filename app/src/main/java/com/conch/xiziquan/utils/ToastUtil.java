package com.conch.xiziquan.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jiansion on 2016/9/28.
 * ToastUtil
 */

public class ToastUtil {

    private static Toast toast;

    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.cancel();
            toast.setText(msg);
        }
        toast.show();
    }


}
