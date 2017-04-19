package pavlosnicolaou.newsapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnNewsItemClickedListener} interface
 * to handle interaction events.
 */
public class NewsListFragment extends Fragment implements NewsModel.OnListUpdateListener {

    private OnNewsItemClickedListener mListener;

    private RecyclerView newsListView;
    private LinearLayoutManager layoutManager;
    private NewsListAdapter adapter;


    @Override
    public void onListUpdate(ArrayList<News> newsList) {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        //Wire recycler view
        newsListView = (RecyclerView) view.findViewById(R.id.news_list_view);

        //Setup layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        //Attach to recycler view
        newsListView.setLayoutManager(layoutManager);

        //Setup adapter
        adapter = new NewsListAdapter(getActivity());

        //Attach to recycler view
        newsListView.setAdapter(adapter);

        //Adding a line between each Cell
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), layoutManager.getOrientation());
        newsListView.addItemDecoration(divider);

        //Connect to the model
        NewsModel model = NewsModel.getInstance();
        model.setOnListUpdateListener(this);
        model.loadData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewsItemClickedListener) {
            mListener = (OnNewsItemClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNewsItemClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNewsItemClickedListener {
        void onNewsItemClicked(int position);
    }
}
