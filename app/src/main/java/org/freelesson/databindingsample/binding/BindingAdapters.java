package org.freelesson.databindingsample.binding;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;

import org.freelesson.databindingsample.R;
import org.freelesson.databindingsample.data.Popularity;

public class BindingAdapters {
    @BindingAdapter("app:hideIfZero")
    public static void hideIfZero(@NonNull View view, Integer number) {
        view.setVisibility(number==0? View.GONE:View.VISIBLE);
    }

    @BindingAdapter(value={"app:progressScaled", "android:max"})
    public static void setProgress(@NonNull ProgressBar progressBar, Integer likes, Integer max) {
        progressBar.setProgress(Math.max(likes *max /100,100));

    }

    @BindingAdapter("app:bindIcon")
    public static void bindIcon(@NonNull ImageView image,Popularity popularity) {
        int color = getAssociatedColor(popularity, image.getContext());
        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color));
        image.setImageDrawable(getDrawablePopularity(popularity,image.getContext()));
    }
    private static Integer getAssociatedColor(Popularity popularity, Context context) {
        if(popularity == Popularity.STAR)
            return ContextCompat.getColor(context, R.color.star);
        else if (popularity == Popularity.POPULAR)
            return ContextCompat.getColor(context,R.color.popular);
        else {
            int[] colorArray=  {(android.R.attr.colorForeground)};
            return context.getTheme().obtainStyledAttributes(colorArray).getColor(0, 0x000000);
        }
    }
    private static Drawable getDrawablePopularity(Popularity popularity, Context context) {
        if(popularity == Popularity.STAR||popularity == Popularity.POPULAR)
            return ContextCompat.getDrawable(context,R.drawable.ic_whatshot_black_96dp);
        else
            return ContextCompat.getDrawable(context,R.drawable.ic_person_black_96dp);

    }
}
