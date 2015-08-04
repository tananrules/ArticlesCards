package com.example.tanan.articlescards;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tanan on 4/8/15.
 */
public class PostListRowHolder extends RecyclerView.ViewHolder {

    protected ImageView ivArticleImage;
    protected TextView tvHeading;

    public PostListRowHolder(View itemView) {
        super(itemView);
        this.ivArticleImage = (ImageView) itemView.findViewById(R.id.ivArticleImage);
        this.tvHeading = (TextView) itemView.findViewById(R.id.tvHeading);
    }
}
