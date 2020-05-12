package com.example.musicplayerproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerproject.R;
import com.example.musicplayerproject.adapters.FreshTracksRVAdapter;

import java.util.ArrayList;

public class FreshTracksFragments extends Fragment {

    private static final String TAG = "FreshTracksFragments";

    View myFragment;
    private ArrayList<String> mFTFOMNames = new ArrayList<>();
    private ArrayList<String> mFTFOMImageRes = new ArrayList<>();
    private ArrayList<String> mFTTRTNames = new ArrayList<>();
    private ArrayList<String> mFTTRTImageRes = new ArrayList<>();
    private ArrayList<String> mFTMCNames = new ArrayList<>();
    private ArrayList<String> mFTMCImageRes = new ArrayList<>();
    private ArrayList<String> mFTNMNames = new ArrayList<>();
    private ArrayList<String> mFTNMImageRes = new ArrayList<>();


    public static FreshTracksFragments getInstance(){
        return new FreshTracksFragments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.activity_ftfragment, container, false);

        initFTRecyclerViewFOM();
        initFTRecyclerViewTRT();
        initFTRecyclerViewMC();
        initFTRecyclerViewNM();

        return myFragment;
    }

    public void initFTRecyclerViewFOM() {

        initFTImagesFOM();

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView1 = myFragment.findViewById(R.id.ft_rv_1);
        FreshTracksRVAdapter adapter1 = new FreshTracksRVAdapter(getActivity().getApplicationContext(), mFTFOMNames, mFTFOMImageRes);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(layoutManager1);

    }

    public void initFTImagesFOM() {

        //Pass all the urls for history from here
        Log.d(TAG, "initFTImagesFOM: preparing Fresh on Musify bitmaps.");

        mFTFOMImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mFTFOMNames.add("Shape of You");

        mFTFOMImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mFTFOMNames.add("Dark Side of Moon");

        mFTFOMImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mFTFOMNames.add("Havana");

        mFTFOMImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mFTFOMNames.add("Despacito");

        mFTFOMImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mFTFOMNames.add("Cheap Thrills");

        mFTFOMImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mFTFOMNames.add("Taki Taki");

        mFTFOMImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mFTFOMNames.add("Senorita");

        mFTFOMImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mFTFOMNames.add("On my Way");

    }

    public void initFTRecyclerViewTRT() {

        initFTImagesTRT();

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView2 = myFragment.findViewById(R.id.ft_rv_2);
        FreshTracksRVAdapter adapter2 = new FreshTracksRVAdapter(getActivity().getApplicationContext(), mFTTRTNames, mFTTRTImageRes);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(layoutManager2);

    }

    public void initFTImagesTRT() {

        //Pass all the urls for history from here
        Log.d(TAG, "initFTImagesTRT: preparing Top Rated Tracks bitmaps.");

        mFTTRTImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mFTTRTNames.add("");

        mFTTRTImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mFTTRTNames.add("");

    }

    public void initFTRecyclerViewMC() {

        initFTImagesMC();

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView3 = myFragment.findViewById(R.id.ft_rv_3);
        FreshTracksRVAdapter adapter3 = new FreshTracksRVAdapter(getActivity().getApplicationContext(), mFTMCNames, mFTMCImageRes);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(layoutManager3);

    }

    public void initFTImagesMC() {

        //Pass all the urls for history from here
        Log.d(TAG, "initFTImagesMC: preparing Musify ChartBusters bitmaps.");

        mFTMCImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mFTMCNames.add("");

        mFTMCImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mFTMCNames.add("");

    }

    public void initFTRecyclerViewNM() {

        initFTImagesNM();

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView4 = myFragment.findViewById(R.id.ft_rv_4);
        FreshTracksRVAdapter adapter4 = new FreshTracksRVAdapter(getActivity().getApplicationContext(), mFTNMNames, mFTNMImageRes);
        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(layoutManager4);

    }

    public void initFTImagesNM() {

        //Pass all the urls for history from here
        Log.d(TAG, "initFTImageNM: preparing New Melodies bitmaps.");

        mFTNMImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mFTNMNames.add("");

        mFTNMImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mFTNMNames.add("");

    }

}
