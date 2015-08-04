package com.example.tanan.articlescards;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit.RestAdapter;

/**
 * Created by tanan on 4/8/15.
 */
public class ArticlesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private PostsObject mPostsObject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cards_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.cards_recycler_view);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        mPostsObject = new PostsObject();
        mPostsObject.posts = new ArrayList<>();
        adapter = new ArticleAdapter(getActivity(), mPostsObject);
        recyclerView.setAdapter(adapter);

        new GetArticles().execute();

        return view;

    }

    public class GetArticles extends AsyncTask<Void, Void, PostsObject> {

        @Override
        protected PostsObject doInBackground(Void... params) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://blog.teamtreehouse.com")
                    .build();

            ArticlesService articlesService = restAdapter.create(ArticlesService.class);

            return articlesService.getArticles();
        }

        @Override
        protected void onPostExecute(PostsObject postsObject) {
            super.onPostExecute(postsObject);
            mPostsObject.posts.addAll(postsObject.posts);
            adapter.notifyDataSetChanged();
        }
    }
}
