package com.sundar.jsongetdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInterface {

    @GET("posts")
    Call<List<DataModel>> getAllData();
}
