package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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


    //Tool bar Buttons Setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_news_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here

        int id = item.getItemId();

        if (id == R.id.search_btn) {
            Log.i("Search Button Tapped", "Search");
            return true;
        } else if (id == R.id.favourite_btn) {
            Log.i("Favourite Button Tapped", "Favourites");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
