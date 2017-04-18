package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_article);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("ITEM_ID", 0);

        //Get the fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        NewsArticleFragment fragment = (NewsArticleFragment) fragmentManager.findFragmentById(R.id.article_fragment);
        fragment.updateDetails(itemId);
    }
}
