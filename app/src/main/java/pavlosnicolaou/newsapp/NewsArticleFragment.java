package pavlosnicolaou.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class NewsArticleFragment extends Fragment {

    private TextView newsName;
    private TextView newsDetails;
    private TextView newsArticle;
    private NetworkImageView photo;

    //Share Button
    private FloatingActionButton shareBtn;

    //Progress Bar
//    private ProgressBar progressBar;

    public NewsArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_article, container, false);

        //Set up photo with animation
        photo = (NetworkImageView) view.findViewById(R.id.imageView);
        photo.animate().alpha(1f).setDuration(3000);

        newsName = (TextView) view.findViewById(R.id.newsName);
        newsDetails = (TextView) view.findViewById(R.id.newsDetails);
        newsArticle = (TextView) view.findViewById(R.id.newsArticle);
        //Make the textView scrollable
        newsArticle.setMovementMethod(new ScrollingMovementMethod());

        shareBtn = (FloatingActionButton) view.findViewById(R.id.shareBtn);
//        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareBtnPressed();
            }
        });

        return view;
    }

    public void updateDetails(int id) {
        //Use the id to get the news object
        News news = NewsModel.getInstance().getNewsList().get(id);

        Log.d("NewsArticleFragment", "Got " + news.getNewsName() + " " + news.getNewsDetails());
        newsName.setText(news.getNewsName());
        newsDetails.setText(news.getNewsDetails());
        newsArticle.setText(news.getArticle());
        photo.setImageUrl(news.getImageUrl(), NewsApp.getInstance().getImageLoader());

    }

    private void shareBtnPressed() {
        //Sharing Implementation
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("message/rfc822");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, newsName.getText());
        sharingIntent.putExtra(Intent.EXTRA_TEXT, newsArticle.getText());

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
