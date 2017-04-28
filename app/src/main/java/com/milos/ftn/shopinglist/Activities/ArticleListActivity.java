package com.milos.ftn.shopinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.milos.ftn.shopinglist.Adapter.ArticlesAdapter;
import com.milos.ftn.shopinglist.Model.Article;
import com.milos.ftn.shopinglist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milos on 4/27/2017.
 */

public class ArticleListActivity extends AppCompatActivity {

    private ListView listView;
    private ArticlesAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        init();

    }


    private void init() {
        // get listView's reference
        listView = (ListView) findViewById(R.id.listView1);
        Intent intent = getIntent();
        // j = number of created lists
        int j = intent.getIntExtra(("numberOfLists"),0);

        // initialize items
        final List<Article> articleList = new ArrayList<>();

        for (int i = 0; i < j; i++) {
            articleList.add(new Article("Article "+ i ,  i, true));
        }

        // initialize adapter
        adapter = new ArticlesAdapter(this, articleList);

        // set adapter to list
        listView.setAdapter(adapter);
    }
}
