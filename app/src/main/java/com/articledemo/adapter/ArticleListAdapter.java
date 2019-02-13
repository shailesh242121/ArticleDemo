package com.articledemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.articledemo.R;
import com.articledemo.interfaces.IRecyclerViewClick;
import com.articledemo.network.model.Articles;

import java.util.ArrayList;
import java.util.List;

/**
 * Article adapter showing in list
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolderArticle> {

    private List<Articles> mList = new ArrayList<>();
    private IRecyclerViewClick mCLick;

    public ArticleListAdapter(List<Articles> list) {
        this.mList = list;
    }

    /**
     * Recycler view item click listener
     *
     * @param click
     */
    public void setListener(IRecyclerViewClick click) {
        mCLick = click;
    }

    @NonNull
    @Override
    public ViewHolderArticle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_article, viewGroup, false);
        return new ViewHolderArticle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticle viewHolder, final int post) {
        viewHolder.setData(mList.get(post));
        viewHolder.itemView.setOnClickListener(v -> {
            if (mCLick != null) {
                mCLick.onItemClick(post, mList.get(post));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolderArticle extends RecyclerView.ViewHolder {

        private TextView tvHeader;
        private TextView tvFooter;
        private TextView tvTime;

        public ViewHolderArticle(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_name);
            tvFooter = itemView.findViewById(R.id.tv_detail);
            tvTime = itemView.findViewById(R.id.tv_time);
        }

        /**
         * Setting data for the row
         *
         * @param articles data for row
         */
        public void setData(Articles articles) {
            tvHeader.setText(articles.getTitle());
            tvFooter.setText(articles.getByline());
            tvTime.setText(articles.getPublishedDate());
        }
    }
}
