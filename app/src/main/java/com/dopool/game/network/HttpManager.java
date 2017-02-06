package com.dopool.game.network;

import com.dopool.game.model.MeiZiBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public class HttpManager {

    public static final String BASE_URL = "http://gank.io/api/data/福利/10/";


    public static void loadFuLi(final OnSuccessListener listener){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(ApiService.class).loadMeiZiBean().enqueue(new Callback<MeiZiBean>() {
            @Override
            public void onResponse(Call<MeiZiBean> call, Response<MeiZiBean> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MeiZiBean> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public interface OnSuccessListener{
        void onSuccess(MeiZiBean meiZiBean);
        void onError(String e);
    }


}
