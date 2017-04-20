package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

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
                Intent i = new Intent(AboutMeActivity.this, NewsListActivity.class);
                startActivity(i);
            }
        });

        nightModeOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Intent i = new Intent(AboutMeActivity.this, NewsListActivity.class);
                startActivity(i);
            }
        });
    }
}
