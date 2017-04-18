package pavlosnicolaou.newsapp;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by pavlos on 18/04/2017.
 */

public class NewsApp extends Application {

    private static NewsApp instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Instance of the singleton application object
        instance = this;
        //Create the request queue
        requestQueue = Volley.newRequestQueue(this);

        //Create the image loader
        int cacheSize = 4 * 1024 * 1024; // 4MiB
        imageLoader = new ImageLoader(requestQueue, new LruBitmapCache(cacheSize));
    }

    public static NewsApp getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
