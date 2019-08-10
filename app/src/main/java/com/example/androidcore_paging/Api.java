package com.example.androidcore_paging;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("answers")
    Call<StackApiResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int size,
//            @Query("order") String order,
//            @Query("sort") String sort,
            @Query("site") String site
    );

}
