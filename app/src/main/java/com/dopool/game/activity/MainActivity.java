package com.dopool.game.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dopool.game.R;
import com.dopool.game.fragment.BaseFragment;
import com.dopool.game.fragment.ContactFragment;
import com.dopool.game.fragment.GameFragment;
import com.dopool.game.fragment.MusicFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                BaseFragment bf = null ;
               switch (tabId) {
                   case R.id.tab_contact:
                       bf = new ContactFragment();
                       break;
                   case R.id.tab_game:
                       bf = new GameFragment();
                       break;
                   case R.id.tab_music:
                       bf = new MusicFragment();
                       break;
                   default:
                       break;
               }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, bf)
                        .commit();
            }
        });

    }

    private Toast mToast;
    /**
     * 吐司
     * @param text
     */
    public  void showToast(String text){
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

}
