package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class NewsListActivity extends AppCompatActivity implements NewsListFragment.OnNewsItemClickedListener {

    private boolean hasTwoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        if (findViewById(R.id.article_fragment) == null) {
            hasTwoPanes = false;
        } else {
            hasTwoPanes = true;
        }
    }

    @Override
    public void onNewsItemClicked(int position) {

        if (hasTwoPanes) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            NewsArticleFragment fragment = (NewsArticleFragment) fragmentManager
                    .findFragmentById(R.id.article_fragment);
        } else {
            //Switch activity
            Intent intent = new Intent(this, NewsArticleActivity.class);
            intent.putExtra("ITEM_ID", position);
            startActivity(intent);
        }
    }
}
