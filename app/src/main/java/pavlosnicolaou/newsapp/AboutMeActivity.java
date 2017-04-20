package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
<<<<<<< HEAD
import android.support.v7.widget.Toolbar;
=======
>>>>>>> ecbf9fccec71f67e75bd5675d0f2b5b9252bb9e1
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AboutMeActivity extends AppCompatActivity {

    private TextView followMeBtn;
    private TextView emailBtn;
    private Button nightModeOnBtn, nightModeOffBtn;
<<<<<<< HEAD
    private Toolbar toolbar;
=======
>>>>>>> ecbf9fccec71f67e75bd5675d0f2b5b9252bb9e1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

<<<<<<< HEAD
        //Add links
        initLinks();

        //Use Night Mode Functionality
        initNightMode();

        //Add Toolbar
        initToolBar();
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.news_item_toolbar);

        setSupportActionBar(toolbar);
        //add Title to toolbar
        toolbar.setTitle("Article");

        toolbar.setNavigationIcon(R.drawable.ic_home);
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

    public void initNightMode() {
        //Night Mode Setup
        //Default Night Mode as not a night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        nightModeOnBtn = (Button) findViewById(R.id.nightModeOnBtn);
        nightModeOffBtn = (Button) findViewById(R.id.nightModeOffBtn);

        nightModeOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Intent i = new Intent(AboutMeActivity.this, NewsListActivity.class);
                startActivity(i);
            }
        });

        nightModeOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
=======
        //link setup
        followMeBtn = (TextView) findViewById(R.id.textViewLink);

        followMeBtn.setMovementMethod(LinkMovementMethod.getInstance());
        String linkText = "Follow me on <a href='http://instagram.com/pavlosnic'>Instagram</a>";
        followMeBtn.setText(Html.fromHtml(linkText));
        followMeBtn.setMovementMethod(LinkMovementMethod.getInstance());

        //email setup
        emailBtn = (TextView) findViewById(R.id.email_txt);

        String email = "Email me: <a href=\"pn94@kent.ac.uk\">pn94@kent.ac.uk</a>";
        emailBtn.setText(Html.fromHtml(email));
        emailBtn.setMovementMethod(LinkMovementMethod.getInstance());


        //Night Mode Setup
        //Default Night Mode as not a night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        nightModeOnBtn = (Button) findViewById(R.id.nightModeOnBtn);
        nightModeOffBtn = (Button) findViewById(R.id.nightModeOffBtn);

        nightModeOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
>>>>>>> ecbf9fccec71f67e75bd5675d0f2b5b9252bb9e1
                Intent i = new Intent(AboutMeActivity.this, NewsListActivity.class);
                startActivity(i);
            }
        });
    }

    public void initLinks() {
        //link setup
        followMeBtn = (TextView) findViewById(R.id.textViewLink);

        followMeBtn.setMovementMethod(LinkMovementMethod.getInstance());
        String linkText = "Follow me on <a href='http://instagram.com/pavlosnic'>Instagram</a>";
        followMeBtn.setText(Html.fromHtml(linkText));
        followMeBtn.setMovementMethod(LinkMovementMethod.getInstance());

        //email setup
        emailBtn = (TextView) findViewById(R.id.email_txt);

<<<<<<< HEAD
        String email = "Email me: <a href=\"pn94@kent.ac.uk\">pn94@kent.ac.uk</a>";
        emailBtn.setText(Html.fromHtml(email));
        emailBtn.setMovementMethod(LinkMovementMethod.getInstance());
=======
        nightModeOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Intent i = new Intent(AboutMeActivity.this, NewsListActivity.class);
                startActivity(i);
            }
        });
>>>>>>> ecbf9fccec71f67e75bd5675d0f2b5b9252bb9e1
    }
}
