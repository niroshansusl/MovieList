package com.movieslist.movies.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.movieslist.movies.R;
import com.movieslist.movies.model.BeanMovie;
import com.movieslist.movies.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niroshan on 8/29/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> implements Filterable {

    private List<BeanMovie> movies;
    private List<BeanMovie> mFilteredList;
    private int rowLayout;
    private Activity context;
    private View view;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout moviesLayout;
        TextView movieTitle;
        TextView cinema_one, cinema_two;
        TextView btn_one, btn_two;
        ImageView image_poster;
        RatingBar rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (RelativeLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            cinema_one = (TextView) v.findViewById(R.id.cinema_one);
            cinema_two = (TextView) v.findViewById(R.id.cinema_two);
            btn_one = (TextView) v.findViewById(R.id.btn_one);
            btn_two = (TextView) v.findViewById(R.id.btn_two);
            rating = (RatingBar) v.findViewById(R.id.rating_bar);
            image_poster = (ImageView) v.findViewById(R.id.image_poster);
        }
    }

    public MoviesAdapter(List<BeanMovie> movies, int rowLayout, Activity context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
        this.mFilteredList = movies;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

            Float rateValue = Float.valueOf(mFilteredList.get(position).getImdb_rate().toString());

            holder.movieTitle.setText(mFilteredList.get(position).getMovie_name());

            AppUtils.setTextViewFontSizeBasedOnScreenDensity(context, holder.movieTitle, 20.0f);
            AppUtils.setTextViewFontSizeBasedOnScreenDensity(context, holder.cinema_one, 24.0f);
            AppUtils.setTextViewFontSizeBasedOnScreenDensity(context, holder.cinema_two, 24.0f);
            AppUtils.setTextViewFontSizeBasedOnScreenDensity(context, holder.btn_one, 22.0f);
            AppUtils.setTextViewFontSizeBasedOnScreenDensity(context, holder.btn_two, 22.0f);

            if (mFilteredList.get(position).getTheater().size() > 1) {
                holder.cinema_one.setText(mFilteredList.get(position).getTheater().get(0).getName());
                holder.cinema_two.setText(mFilteredList.get(position).getTheater().get(1).getName());
            } else if (mFilteredList.get(position).getTheater().size() == 1) {
                holder.cinema_one.setText(mFilteredList.get(position).getTheater().get(0).getName());
                holder.cinema_two.setVisibility(View.GONE);
            }

            if (!AppUtils.isExpire(mFilteredList.get(position).getBooking_start_date())) {
                holder.btn_one.setText("" + AppUtils.getMonthDate(mFilteredList.get(position).getBooking_start_date()));
                holder.btn_one.setBackgroundResource(R.color.colorGreyLight);
                holder.btn_two.setText(context.getResources().getString(R.string.btn_more));
                holder.btn_two.setBackgroundResource(R.color.colorGrey);
            } else {

            }

            holder.rating.setStepSize((float) 0.1);
            holder.rating.setRating(rateValue);
            AppUtils.loadImageWithPlaceholder(this.context, mFilteredList.get(position).getPortrait_image(), holder.image_poster, R.drawable.spiderman);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = movies;
                } else {

                    List<BeanMovie> filteredList = new ArrayList<>();

                    for (BeanMovie moviesList : movies) {

                        if (moviesList.getMovie_name().toLowerCase().contains(charString)) {

                            filteredList.add(moviesList);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<BeanMovie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}