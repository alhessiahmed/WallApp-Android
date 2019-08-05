package com.example.dndoonwallpaper.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class SecondViewPagerAdapter extends PagerAdapter {

    private List<String> urls;

    public SecondViewPagerAdapter(List<String> urls){
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView displayImageOnly = new ImageView(container.getContext());
        Glide.with(container.getContext())
                .load(urls.get(position))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(RequestOptions.centerCropTransform())
                .into(displayImageOnly);
        container.addView(displayImageOnly);
        return displayImageOnly;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}