package com.dopool.game.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class MyCardImage extends CardView {

    private ImageView mImageView;

    public MyCardImage(Context context) {
        super(context);
        init();
    }

    public MyCardImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCardImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        setRadius(15);
        mImageView = new ImageView(getContext());
        addView(mImageView);
        mImageView.requestLayout();
    }

    public ImageView getImageView(){

        return mImageView;
    }

}
