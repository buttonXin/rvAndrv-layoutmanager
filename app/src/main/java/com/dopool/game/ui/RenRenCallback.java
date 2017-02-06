package com.dopool.game.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.dopool.game.adapter.MyAdapter;
import com.dopool.game.model.GameBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class RenRenCallback extends ItemTouchHelper.Callback {

    private List<GameBean> mGameBeen;
    private MyAdapter mMyAdapter ;

    public RenRenCallback(List<GameBean> gameBeen, MyAdapter myAdapter) {
        mGameBeen = gameBeen;
        mMyAdapter = myAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        return 0;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
