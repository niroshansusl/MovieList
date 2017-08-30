package com.movieslist.movies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import com.movieslist.movies.R;
import com.movieslist.movies.adapter.MoviesAdapter;
import com.movieslist.movies.fragment.ProgressDialogFragment;
import com.movieslist.movies.model.BeanMovie;
import com.movieslist.movies.model.BeanMoviesResponse;
import com.movieslist.movies.rest.ApiClient;
import com.movieslist.movies.rest.ApiInterface;
import com.movieslist.movies.utils.AppUtils;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MoviesAdapter mAdapter;
    private RecyclerView recyclerView;
    private TextView tv_toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        loadMovieList();

    }

    private void initViews(){

        tv_toolbar_title = (TextView) findViewById(R.id.tv_toolbar_title);
        AppUtils.setTextViewFontSizeBasedOnScreenDensity(MainActivity.this, tv_toolbar_title, 20.0f);
        tv_toolbar_title.setText(R.string.title);

        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        search(searchView);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }

    private void loadMovieList(){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<BeanMoviesResponse> call = apiService.getTopRatedMovies();
        final ProgressDialogFragment dialogFragment = AppUtils.showProgressDialog(this);
        call.enqueue(new Callback<BeanMoviesResponse>() {
            @Override
            public void onResponse(Call<BeanMoviesResponse> call, Response<BeanMoviesResponse> response) {
               //int statusCode = response.code();
                List<BeanMovie> movies = response.body().getData();
                mAdapter = new MoviesAdapter(movies, R.layout.list_item_movie, MainActivity.this);
                recyclerView.setAdapter(mAdapter);
                AppUtils.closeProgressDialog(dialogFragment);
            }

            @Override
            public void onFailure(Call<BeanMoviesResponse> call, Throwable t) {
                // Log error here since request failed
                AppUtils.closeProgressDialog(dialogFragment);
                Log.e(TAG, t.toString());
            }
        });
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}

