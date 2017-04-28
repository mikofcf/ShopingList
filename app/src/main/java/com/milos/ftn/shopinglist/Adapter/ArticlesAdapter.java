package com.milos.ftn.shopinglist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.milos.ftn.shopinglist.Model.Article;
import com.milos.ftn.shopinglist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milos on 4/27/2017.
 */

public class ArticlesAdapter extends BaseAdapter{

    private List<Article> articles = new ArrayList<>();

    private final LayoutInflater layoutInflater;

    private final Context context;

    public ArticlesAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            // create a new view holder since we don't have a view to reuse
            viewHolder = new ViewHolder();

            // inflate view item
            convertView = layoutInflater.inflate(R.layout.view_item_article, parent, false);

            // store the views in a view holder for later reuse
            //viewHolder.done = (CheckBox) convertView.findViewById(R.id.done);
            viewHolder.article = (CheckedTextView) convertView.findViewById(R.id.article);
           // viewHolder.ammount = (TextView) convertView.findViewById(R.id.ammount);


            // save view holder for later reuse
            convertView.setTag(viewHolder);
        } else {
            // we already have a view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // get item
        final Article article = (Article) getItem(position);

        // populate view item with task's data
        //viewHolder.done.setChecked(article.isDone());
        viewHolder.article.setText(article.getName());
        viewHolder.article.setCheckMarkDrawable(R.drawable.ic_check);


        return convertView;
    }

    private static class ViewHolder {

        private CheckBox done;

        private CheckedTextView article;

        private TextView ammount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
