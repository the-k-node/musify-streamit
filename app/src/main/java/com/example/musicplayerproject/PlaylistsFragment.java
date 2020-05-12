package com.example.musicplayerproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerproject.adapters.PlayListRVAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaylistsFragment extends Fragment {

    Toolbar toolbar;
    View myFragment;
    private ArrayList<String> mPlaylistNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();

    public static PlaylistsFragment getInstance(){
        return new PlaylistsFragment();
    }

    public PlaylistsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_playlists, container, false);
        toolbar = (Toolbar)myFragment.findViewById(R.id.custom_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        initRecyclerPlaylistView();
        // Inflate the layout for this fragment
        return myFragment;
    }
    public void initRecyclerPlaylistView(){
        initImageResView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = myFragment.findViewById(R.id.playlist_recyclerView);
        PlayListRVAdapter adapter = new PlayListRVAdapter(getActivity().getApplicationContext(),mPlaylistNames,mImageResources);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void initImageResView(){
        mImageResources.add(R.drawable.gradblue_cardbg);
        mPlaylistNames.add("Party \nCharts");
        mImageResources.add(R.drawable.gradgreen_cardbg);
        mPlaylistNames.add("Sad \nBeats");
        mImageResources.add(R.drawable.gradpurple_cardbg);
        mPlaylistNames.add("Mood \nBoosters");
        mImageResources.add(R.drawable.gradyellow_cardbg);
        mPlaylistNames.add("Feelin' \nGood");
        mImageResources.add(R.drawable.gradblue_cardbg);
        mPlaylistNames.add("Romantic \nAcoustics");
        mImageResources.add(R.drawable.gradgreen_cardbg);
        mPlaylistNames.add("Dreamy \nVibes");
    }


}
