package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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

        initAdView();

    }

    public void initAdView() {

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

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

    //Tool bar Buttons Setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_news_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here

        int id = item.getItemId();

        if (id == R.id.favourite_btn) {
            Log.i("Favourite Button Tapped", "Favourites");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
