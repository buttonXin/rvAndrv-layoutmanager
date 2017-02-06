package com.dopool.game.ui;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class CardConfig {

    //屏幕上最多显示的item
    public static  int MAX_SHOW_COUNT ;
    //没一个item的scale都擦了相差0.05f ， translationY 相差7dp
    public static float SCALE_GAP ;
    public static int TRANSLATION_Y_GAP;

    public static void config(Context context){
        MAX_SHOW_COUNT = 4 ;
        SCALE_GAP = 0.05f ;
        TRANSLATION_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP ,
                15 , context.getResources().getDisplayMetrics());
    }

}
