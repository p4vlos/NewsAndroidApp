package pavlosnicolaou.newsapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by vl1s on 14/04/2017.
 */

public class NewsModel {
    private static final NewsModel ourInstance = new NewsModel();
    private OnListUpdateListener listUpdateListener;

    public static NewsModel getInstance() {
        return ourInstance;
    }

    private ArrayList<News> newsList = new ArrayList<News>();

    private NewsModel() {

    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    private Response.Listener<JSONArray> netListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {

            //Clean newsList from old data
            newsList.clear();
            try {
                for (int i=0; i < response.length(); i++) {
                    JSONObject obj = response.getJSONObject(i);
                    News news = new News(
                            obj.getInt("record_id"),
                            obj.getString("title"),
                            obj.getString("date"),
                            obj.getString("short_info"),
                            obj.getString("image_url")
                    );
                    newsList.add(news);
                }
            } catch (JSONException e) {

            }
            notifyListener();
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    public void loadData() {
        //Create a request object
        JsonArrayRequest request = new JsonArrayRequest(
                "http://www.efstratiou.info/projects/newsfeed/getList.php",
                netListener, errorListener);
        //Submit request
        NewsApp.getInstance().getRequestQueue().add(request);
    }

    public void setOnListUpdateListener(OnListUpdateListener listUpdateListener) {
        this.listUpdateListener = listUpdateListener;
    }

    public interface OnListUpdateListener {
        void onListUpdate(ArrayList<News> newsList);
    }

    private void notifyListener() {
        if (listUpdateListener != null)
            listUpdateListener.onListUpdate(newsList);
    }
}
