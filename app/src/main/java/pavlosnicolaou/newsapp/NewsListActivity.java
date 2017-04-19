package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class NewsListActivity extends AppCompatActivity implements NewsListFragment.OnNewsItemClickedListener {

    private boolean hasTwoPanes;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        if (findViewById(R.id.article_fragment) == null) {
            hasTwoPanes = false;
        } else {
            hasTwoPanes = true;
        }

        initToolBar();
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

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.news_item_toolbar);

        setSupportActionBar(toolbar);
        //add Title to toolbar
        toolbar.setTitle("News");

        toolbar.setNavigationIcon(R.drawable.ic_person);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
               goToAboutMe();
            }
        });
    }

    private void goToAboutMe() {
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }
}
