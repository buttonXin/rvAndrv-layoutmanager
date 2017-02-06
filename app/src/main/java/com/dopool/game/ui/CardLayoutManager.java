package com.dopool.game.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class CardLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT ,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        //葱可见的最底层开始layout ，依次层叠上去
        for (int position = itemCount - CardConfig.MAX_SHOW_COUNT ; position < itemCount; position++) {
            View view = recycler.getViewForPosition(position);
            addView(view);
            measureChildWithMargins(view , 0 , 0);

            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
            //在布局时，将view放到中间
            layoutDecoratedWithMargins(view , widthSpace /2 , heightSpace / 2 ,
                    getDecoratedMeasuredWidth(view) + widthSpace /2 ,
                    getDecoratedMeasuredHeight(view) + heightSpace / 2 );

            int level = itemCount - position -1 ;
            if (level > 0){
                //每一层都需要X方向缩小
                view.setScaleX( 1 - CardConfig.SCALE_GAP * level);
                //钱N层 ，依次Y 缩小 ， Y平移
                if (level < CardConfig.MAX_SHOW_COUNT - 1){
                    view.setTranslationY(CardConfig.TRANSLATION_Y_GAP * level);
                    view.setScaleX( 1 -  CardConfig.SCALE_GAP * level );

                }else {//在N层 向下位移 和Y方向的程度 与 N-1 保持一致
                    view.setTranslationY(CardConfig.TRANSLATION_Y_GAP * (level- 1));
                    view.setScaleX( 1 -  CardConfig.SCALE_GAP * (level - 1 ) );
                }
            }

        }

    }
}
















