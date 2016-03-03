package com.example.weiqiliu.materialdesign.service;

import com.example.weiqiliu.materialdesign.domain.Envelope;
import com.example.weiqiliu.materialdesign.domain.FeedbackRequest;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface GitHubService {
    @GET("/users/{user}/repos")
    public Call<Envelope> listRepos(@Path("user") String user);

    @GET("/users/{user}/repos")
    public List<String> listeee(@Path("user") String user, Callback<List<String>> callback);

    @POST("/other/feedback")
    public Observable<Envelope> sendFeedbackRequestEnvelope(
            @Body FeedbackRequest reques);

    @GET("/stream/list.json")
    void getStreams(@Query("limit") int limit, @Query("offset") int offset, Callback<List> callback);

    @POST("list")
    Call<Envelope> loadRepo();

}
