package com.example.dndoonwallpaper.fragments.viewPagerFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndoonwallpaper.R;
import com.example.dndoonwallpaper.adapters.WallpaperAdapter;
import com.example.dndoonwallpaper.model.Wallpaper;

import java.util.ArrayList;
import java.util.List;

public class FirstViewPagerFragment extends Fragment {

    private List<Wallpaper> wallpapers = new ArrayList<>();
    private View fragmentView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_first_view_pager, container, false);
        initiateComponents();
        setupRecyclerView();
        fakeData();
        return fragmentView;
    }

    private void initiateComponents(){
        swipeRefreshLayout = fragmentView.findViewById(R.id.swipeRefreshLayout);
        recyclerView = fragmentView.findViewById(R.id.recyclerView);
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
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       swipeRefreshLayout.setRefreshing(false);
                    }
                }, 5000);
                //TODO call API again
            }
        });

    }

    private void fakeData(){
        wallpapers.clear();
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));
        wallpapers.add(new Wallpaper("https://images.unsplash.com/photo-1564498886748-bf757f36f4d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","","Ahmed","Salah"));

    }
}
