package com.example.tanan.articlescards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tanan on 4/8/15.
 */
public class ArticleAdapter extends RecyclerView.Adapter<PostListRowHolder>{

    private PostsObject postsObject;
    private Context context;

    public ArticleAdapter(Context context, PostsObject postsObject) {
        this.context = context;
        this.postsObject = postsObject;
    }

    @Override
    public PostListRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_article_card, parent, false);
        PostListRowHolder postListRowHolder = new PostListRowHolder(view);
        return postListRowHolder;
    }

    @Override
    public void onBindViewHolder(PostListRowHolder holder, int position) {
        holder.tvHeading.setText(postsObject.posts.get(position).title);
    }

    @Override
    public int getItemCount() {
        return postsObject.posts.size();
    }
}
