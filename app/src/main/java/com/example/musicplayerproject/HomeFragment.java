package com.example.musicplayerproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.musicplayerproject.adapters.SectionPagerAdapter;
import com.example.musicplayerproject.fragments.AllFragment;
import com.example.musicplayerproject.fragments.FreshTracksFragments;
import com.example.musicplayerproject.fragments.TopArtistsFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment {
    View myFragment;
    SectionPagerAdapter adapterPager;
    Toolbar toolbar;
    ViewPager mViewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment =  inflater.inflate(R.layout.fragment_home, container, false);
        toolbar = (Toolbar)myFragment.findViewById(R.id.custom_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        tabLayout = myFragment.findViewById(R.id.tabLayout);
        mViewPager = myFragment.findViewById(R.id.viewPager);
        return myFragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(mViewPager);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    private void setUpViewPager(ViewPager mViewPager) {
        adapterPager = new SectionPagerAdapter(getChildFragmentManager());
        adapterPager.addFragment(new AllFragment(),"All");
        adapterPager.addFragment(new FreshTracksFragments(),"Fresh Tracks");
        adapterPager.addFragment(new TopArtistsFragment(),"Top Artists");
        mViewPager.setAdapter(adapterPager);
    }
}
