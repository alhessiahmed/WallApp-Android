package com.example.dndoonwallpaper.fragments.viewPagerFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndoonwallpaper.R;
import com.example.dndoonwallpaper.adapters.SecondViewPagerAdapter;
import com.example.dndoonwallpaper.adapters.ViewPagerAdapter;
import com.example.dndoonwallpaper.adapters.WallpaperAdapter;
import com.example.dndoonwallpaper.model.Wallpaper;

import java.util.ArrayList;
import java.util.List;

public class SecondViewPagerFragment extends Fragment {

    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private SecondViewPagerAdapter viewPagerAdapter;
    private List<String> urls = new ArrayList<>();
    private List<Wallpaper> wallpapers = new ArrayList<>();
    private View fragmentView;
    private SwipeRefreshLayout secondSwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_second_view_pager, container, false);
        fakeData();
        initiateComponents();
        setupRecyclerView();
        return fragmentView;
    }

    private void initiateComponents(){
        viewPager = fragmentView.findViewById(R.id.second_viewPager);
        viewPagerAdapter = new SecondViewPagerAdapter(urls);
        viewPager.setAdapter(viewPagerAdapter);
        recyclerView = fragmentView.findViewById(R.id.second_recyclerView);
        secondSwipeRefreshLayout = fragmentView.findViewById(R.id.secondSwipeRefreshLayout);
    }

    private void setupRecyclerView(){
        WallpaperAdapter adapter = new WallpaperAdapter(wallpapers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        adapter.setListener(new WallpaperAdapter.ClickListener() {
            @Override
            public void onItemClick(int position) {
                // TODO open img in full screen
            }
        });
        secondSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        secondSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        secondSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 5000);
                //TODO call API again
            }
        });

    }

    private void fakeData(){
        urls.clear();
        urls.add("https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260");
        urls.add("https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        urls.add("https://images.pexels.com/photos/814499/pexels-photo-814499.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        urls.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        urls.add("https://images.pexels.com/photos/37319/underwear-beauty-model-western-model-offered.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.pexels.com/photos/358457/pexels-photo-358457.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.pexels.com/photos/814499/pexels-photo-814499.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.pexels.com/photos/37319/underwear-beauty-model-western-model-offered.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","","Ahmed","Salah"));
    }

}
