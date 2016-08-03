package com.cafeapp.nizar.cafeapps;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by irfan on 02/08/16.
 */
public interface CafeService {

    /**
     * get list
     */
    @GET("/apicafe/public/list")
    Call<ModelCafe> getDataList();

    /**
     * get detail list
     */
    @GET("/apicafe/public/list/{id}")
    Call<ModelCafeDetail> getDataList(@Path("id") String id);
}
