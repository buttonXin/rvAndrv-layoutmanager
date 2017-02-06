package com.dopool.game.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.tv.TvView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dopool.game.R;
import com.dopool.game.model.GameBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<GameBean> mGameBeen;

    private Context mContext ;
    public MyAdapter(List<GameBean> gameBeen) {
        mGameBeen = gameBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GameBean gameBean = mGameBeen.get(position);

        if (getItemViewType(position) == 1){
            holder.mImageView.setVisibility(View.GONE);
            holder.mTextView.setVisibility(View.VISIBLE);
            holder.mTextView.setText(gameBean.getText());

        }else {
            holder.mImageView.setVisibility(View.VISIBLE);
            holder.mTextView.setVisibility(View.GONE);
            Glide.with(mContext).load(gameBean.getUrl()).into(holder.mImageView);
        }

    }

    @Override
    public int getItemViewType(int position) {// 1 表示url是空的
        return TextUtils.isEmpty(mGameBeen.get(0).getUrl()) ? 1 : 0 ;
    }

    @Override
    public int getItemCount() {
        return mGameBeen.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTextView;
        private final TextView mCount;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_url);
            mTextView = (TextView) itemView.findViewById(R.id.text_content);
            mCount = (TextView) itemView.findViewById(R.id.text_count);
        }

    }




}
