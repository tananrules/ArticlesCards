package com.example.tanan.articlescards;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by tanan on 4/8/15.
 */
public interface ArticlesService {
    @GET("/api/get_recent_summary/")
    PostsObject getArticles();
}
