package com.example.yishaishani.project_finel;

/**
 * Created by yishaishani on 19/12/2016.
 */



        import android.content.Context;
        import android.widget.Toast;


public class ToastThrower {

    public static void throwToast(Context ctx , String str) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(ctx, str, duration);
        toast.show();
    }

}
