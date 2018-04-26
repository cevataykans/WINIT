package com.example.user.winit;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by USER on 21.04.2018.
 */

public class Pop extends Activity
{
    DisplayMetrics dm;
    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width;
        int height;

        width = dm.widthPixels;
        height = dm.heightPixels;

        getWindow().setLayout( (int) ( width * .8 ), (int) ( height * .6 ) );
    }
}
