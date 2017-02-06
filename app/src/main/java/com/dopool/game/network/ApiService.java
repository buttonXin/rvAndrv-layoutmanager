package com.dopool.game.network;

import com.dopool.game.model.MeiZiBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/1/19 0019.
 */

public interface ApiService {

    @GET("1")
    Call<MeiZiBean> loadMeiZiBean();

}
