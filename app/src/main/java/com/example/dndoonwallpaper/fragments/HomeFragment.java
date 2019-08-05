package com.example.dndoonwallpaper.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndoonwallpaper.R;
import com.example.dndoonwallpaper.adapters.ViewPagerAdapter;
import com.example.dndoonwallpaper.fragments.viewPagerFragments.FirstViewPagerFragment;
import com.example.dndoonwallpaper.fragments.viewPagerFragments.FourthViewPagerFragment;
import com.example.dndoonwallpaper.fragments.viewPagerFragments.SecondViewPagerFragment;
import com.example.dndoonwallpaper.fragments.viewPagerFragments.ThirdViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View fragmentView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        initialComponents();
        setupViewPager();
        return fragmentView;
    }

    private void initialComponents(){
        viewPager = fragmentView.findViewById(R.id.viewpager);
        tabLayout = fragmentView.findViewById(R.id.tabLayout);
    }

    private void setupViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstViewPagerFragment());
        fragments.add(new SecondViewPagerFragment());
        fragments.add(new ThirdViewPagerFragment());
        fragments.add(new FourthViewPagerFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);

        int[][] states = new int[][] {
                new int[] {android.R.attr.state_enabled}// focused
        };
        int[] colors = new int[] {
                Color.parseColor("#ffffff")
        };
        tabLayout.setTabIconTint(new ColorStateList(states, colors));
        tabLayout.setSelectedTabIndicatorColor(Color.CYAN);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_earth);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_explore);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_filter_hdr);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_not_favorite);
    }
}
