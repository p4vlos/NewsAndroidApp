package pavlosnicolaou.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by vl1s on 16/04/2017.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context context;
    private NewsListFragment.OnNewsItemClickedListener listener;
    private NewsModel model = NewsModel.getInstance();

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView newsName;
        private TextView newsDetails;
        private NetworkImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);

            //Bind elements to the layout
            newsName = (TextView) itemView.findViewById(R.id.news_name);
            newsDetails = (TextView) itemView.findViewById(R.id.news_details);
            photo = (NetworkImageView) itemView.findViewById(R.id.photo);

            photo.animate().alpha(1f).setDuration(3000);

            //Click Listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onNewsItemClicked(getAdapterPosition());
                    }
                }
            });
        }


        public void setData(News news) {
            //Set values
            newsName.setText(news.getNewsName());
            newsDetails.setText(news.getNewsDetails());

            photo.setImageUrl(news.getImageUrl(), NewsApp.getInstance().getImageLoader());
        }
    }

    public NewsListAdapter(Context ctx) {
        super();
        context = ctx;

        if (context instanceof NewsListFragment.OnNewsItemClickedListener) {
            listener = (NewsListFragment.OnNewsItemClickedListener) context;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Create the new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_news_item, parent, false);

        //Save view in view holder
        ViewHolder vh = new ViewHolder(v);

        //Return view holder
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Get the relevant object
        News news = model.getNewsList().get(position);

        //Populate the view
        holder.setData(news);

    }

    @Override
    public int getItemCount() {
        return model.getNewsList().size();
    }



}
