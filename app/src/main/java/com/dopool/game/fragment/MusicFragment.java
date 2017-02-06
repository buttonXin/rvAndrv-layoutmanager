package com.dopool.game.fragment;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dopool.game.R;
import com.dopool.game.activity.AppBarActivity;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class MusicFragment extends BaseFragment {

    private Button mButton;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.music_activity, null);
        mButton = (Button) view.findViewById(R.id.button5);
        return view ;
    }

    @Override
    public void initData() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity , AppBarActivity.class ));
            }
        });

    }
}
