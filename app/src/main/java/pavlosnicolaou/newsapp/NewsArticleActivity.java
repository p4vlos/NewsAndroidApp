package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NewsArticleActivity extends AppCompatActivity {

    Toolbar toolbar;

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

        initToolBar();
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.news_item_toolbar);

        setSupportActionBar(toolbar);
        //add Title to toolbar
        toolbar.setTitle("Article");

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
