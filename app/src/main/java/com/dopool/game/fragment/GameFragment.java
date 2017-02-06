package com.dopool.game.fragment;

import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.dopool.game.R;
import com.dopool.game.adapter.MyAdapter;
import com.dopool.game.model.GameBean;
import com.dopool.game.model.MeiZiBean;
import com.dopool.game.network.HttpManager;
import com.dopool.game.ui.CardConfig;
import com.dopool.game.ui.CardLayoutManager;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class GameFragment extends BaseFragment {

    private RecyclerView mRv;
    private List<GameBean> mGameBeen = new ArrayList<>();
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.game_activity, null);

        mRv = (RecyclerView) view.findViewById(R.id.rv_game);
       // LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        CardLayoutManager manager1 = new CardLayoutManager();
        CardConfig.config(mActivity);

        mRv.setLayoutManager(manager1);

        return view ;
    }

    @Override
    public void initData() {


        HttpManager.loadFuLi(new HttpManager.OnSuccessListener() {
            @Override
            public void onSuccess(MeiZiBean meiZiBean) {

                mGameBeen.clear();
                for (MeiZiBean.ResultsBean resultsBean : meiZiBean.getResults()) {
                    if (TextUtils.isEmpty(resultsBean.getUrl())) continue;
                    mGameBeen.add(new GameBean(resultsBean.getUrl() , "  "));
                }

                if (mGameBeen != null) {
                    final MyAdapter myAdapter= new MyAdapter(mGameBeen) ;
                    mRv.setAdapter(myAdapter);

                    ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0 ,
                            ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                        @Override
                        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                            return false;
                        }

                        @Override
                        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                            GameBean remove = mGameBeen.remove(viewHolder.getLayoutPosition());
                            mGameBeen.add(0 , remove);
                            myAdapter.notifyDataSetChanged();
                        }
                    };
                    ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
                    touchHelper.attachToRecyclerView(mRv);
                }
            }

            @Override
            public void onError(String e) {
                Logger.d(e);
            }
        });

    }
}
