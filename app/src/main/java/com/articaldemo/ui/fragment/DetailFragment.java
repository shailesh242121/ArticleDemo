package com.articaldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.articaldemo.R;
import com.articaldemo.mvc.view.ArticleView;
import com.articaldemo.network.model.Articles;
import com.articaldemo.ui.activity.BaseActivity;

/**
 * showing detail of the article
 */
public class DetailFragment extends BaseFragment {
    /**
     *  Item fields
     */
    TextView tvTitle,tvDetail,tvTime;
    TextView tvSource,tvAbstract;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);
        initFragment(view);
        return view;
    }

    /**
     * initilize fragment
     * @param view
     */
    private void initFragment(View view) {
        tvTitle = view.findViewById(R.id.tv_title);
        tvDetail = view.findViewById(R.id.tv_detail);
        tvTime = view.findViewById(R.id.tv_time);
        tvAbstract = view.findViewById(R.id.tvAbstract);
        tvSource = view.findViewById(R.id.tv_source);

        if(getArguments()!=null)
        {
            Articles article = getArguments().getParcelable("article");
            tvTitle.setText(String.format(getString(R.string.title_text),article.getTitle()));
            tvDetail.setText(article.getByline());
            tvTime.setText(String.format(getString(R.string.publishBy_placeholder),article.getPublished_date()));
            tvSource.setText(String.format(getString(R.string.source_placeholder),article.getSource()));
            tvAbstract.setText(String.format(getString(R.string.abstract_placeholer),article.getAbstractType()));

        }

    }
}
