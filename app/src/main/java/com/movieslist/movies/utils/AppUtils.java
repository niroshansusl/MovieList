package com.movieslist.movies.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.movieslist.movies.activity.MainActivity;
import com.movieslist.movies.fragment.ProgressDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Niroshan on 10/13/2016.
 */

public class AppUtils {

    public static void loadImageWithPlaceholder(Context context, String url, ImageView img, int placeholder) {
        Glide.with(context).load(url).into(img);
    }

    public static void loadImageWithDimensions(Context context, String url, ImageView img, int placeholder, int width, int height) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .override(width, height) // resizes the image to these dimensions (in pixel)
                .centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .into(img);
    }

    public static void setTextViewFontSizeBasedOnScreenDensity(
            Activity activity, TextView tv, double size) {

        DisplayMetrics dMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        final float WIDE = activity.getResources().getDisplayMetrics().widthPixels;
        int valueWide = (int) (WIDE / size / (dMetrics.scaledDensity));
        tv.setTextSize(valueWide);
    }

    public static void setTextViewFontSizeBasedOnScreenDensity(
            Activity activity, TextView tv, double size, int style) {

        DisplayMetrics dMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        final float WIDE = activity.getResources().getDisplayMetrics().widthPixels;
        int valueWide = (int) (WIDE / size / (dMetrics.scaledDensity));
        tv.setTextSize(valueWide);
        tv.setTypeface(tv.getTypeface(), style);
    }

    //close ProgressDialogFragment
    public static void closeProgressDialog(ProgressDialogFragment dialogFragment) {
        try {
            dialogFragment.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //show ProgressDialogFragmenta
    public static ProgressDialogFragment showProgressDialog(Activity activity) {
        ProgressDialogFragment dialogFragment = new ProgressDialogFragment();
        try {
            dialogFragment.setCancelable(true);
            dialogFragment.show(((MainActivity) activity).getSupportFragmentManager(), "tag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialogFragment;
    }

    public static boolean isExpire(String date){
        if(date.isEmpty() || date.trim().equals("")){
            return false;
        }else{
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd"); // Jan-20-2015 1:30:55 PM
            Date d=null;
            Date d1=null;
            String today= getToday("yyyy-MM-dd");
            try {
                d = sdf.parse(date);
                d1 = sdf.parse(today);
                if(d1.compareTo(d) <0){// not expired
                    return false;
                }else if(d.compareTo(d1)==0){// both date are same
                    return true;
                }else{//expired
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
    }


    public static String getToday(String format){
        Date date = new Date();
        return new SimpleDateFormat(format).format(date);
    }

    public static String getMonthDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return new SimpleDateFormat("dd MMMM").format(cal.getTime());
    }
}
