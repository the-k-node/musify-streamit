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
import com.example.musicplayerproject.adapters.AllRecyclerViewAdapterforCircle;

import java.util.ArrayList;

public class TopArtistsFragment extends Fragment {

    private static final String TAG = "TopArtistsFragment";

    View myFragment;

    private ArrayList<String> mTEANames = new ArrayList<>();
    private ArrayList<String> mTEAImageRes = new ArrayList<>();
    private ArrayList<String> mTHANames = new ArrayList<>();
    private ArrayList<String> mTHAImageRes = new ArrayList<>();
    private ArrayList<String> mTTANames = new ArrayList<>();
    private ArrayList<String> mTTAImageRes = new ArrayList<>();
    private ArrayList<String> mTKANames = new ArrayList<>();
    private ArrayList<String> mTKAImageRes = new ArrayList<>();

    public static TopArtistsFragment getInstance(){
        return new TopArtistsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.activity_tafragment, container, false);

        initTARecyclerViewTEA();
        initTARecyclerViewTHA();
        initTARecyclerViewTTA();
        initTARecyclerViewTKA();

        return myFragment;
    }

    public void initTARecyclerViewTEA() {
        initTAImagesTEA();

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView1 = myFragment.findViewById(R.id.ta_rv_1);
        AllRecyclerViewAdapterforCircle adapter1 = new AllRecyclerViewAdapterforCircle(getActivity().getApplicationContext(), mTEANames, mTEAImageRes);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(layoutManager1);
    }

    public void initTAImagesTEA(){
        //Pass all the urls for history from here
        Log.d(TAG, "initTAImagesTEA: preparing Top English Artists bitmaps.");

        mTEAImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mTEANames.add("Shape of You");

        mTEAImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mTEANames.add("Cheap Thrills");

        mTEAImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mTEANames.add("Dark Side of Moon");

        mTEAImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mTEANames.add("Taki Taki");

        mTEAImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mTEANames.add("Havana");

        mTEAImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mTEANames.add("Despacito");

        mTEAImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mTEANames.add("Senorita");

        mTEAImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mTEANames.add("On my Way");
    }

    public void initTARecyclerViewTHA() {
        initTAImagesTHA();

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView2 = myFragment.findViewById(R.id.ta_rv_2);
        AllRecyclerViewAdapterforCircle adapter2 = new AllRecyclerViewAdapterforCircle(getActivity().getApplicationContext(), mTHANames, mTHAImageRes);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(layoutManager2);
    }

    public void initTAImagesTHA(){
        //Pass all the urls for TA from here
        Log.d(TAG, "initTAImagesTHA: preparing Top Hindi Artists bitmaps.");

        mTHAImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mTHANames.add("Havana");

        mTHAImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mTHANames.add("Despacito");

        mTHAImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mTHANames.add("Cheap Thrills");

        mTHAImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mTHANames.add("Taki Taki");

        mTHAImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mTHANames.add("Shape of You");

        mTHAImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mTHANames.add("Dark Side of Moon");

        mTHAImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mTHANames.add("Senorita");

        mTHAImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mTHANames.add("On my Way");
    }

    public void initTARecyclerViewTTA() {
        initTAImagesTTA();

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView3 = myFragment.findViewById(R.id.ta_rv_3);
        AllRecyclerViewAdapterforCircle adapter3 = new AllRecyclerViewAdapterforCircle(getActivity().getApplicationContext(), mTTANames, mTTAImageRes);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(layoutManager3);
    }

    public void initTAImagesTTA(){
        //Pass all the urls for TA from here
        Log.d(TAG, "initTAImagesTTA: preparing Top Telugu Artists bitmaps.");

        mTTAImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mTTANames.add("On my Way");

        mTTAImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mTTANames.add("Despacito");

        mTTAImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mTTANames.add("Cheap Thrills");

        mTTAImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mTTANames.add("Taki Taki");

        mTTAImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mTTANames.add("Shape of You");

        mTTAImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mTTANames.add("Dark Side of Moon");

        mTTAImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mTTANames.add("Havana");

        mTTAImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mTTANames.add("Senorita");

    }

    public void initTARecyclerViewTKA() {
        initTAImagesTKA();

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView4 = myFragment.findViewById(R.id.ta_rv_4);
        AllRecyclerViewAdapterforCircle adapter4 = new AllRecyclerViewAdapterforCircle(getActivity().getApplicationContext(), mTKANames, mTKAImageRes);
        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(layoutManager4);
    }

    public void initTAImagesTKA(){
        //Pass all the urls for TA from here
        Log.d(TAG, "initTAImagesTKA: preparing Top Kannada Artists bitmaps.");

        mTKAImageRes.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mTKANames.add("Despacito");

        mTKAImageRes.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mTKANames.add("Cheap Thrills");

        mTKAImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mTKANames.add("Taki Taki");

        mTKAImageRes.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mTKANames.add("Shape of You");

        mTKAImageRes.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mTKANames.add("Dark Side of Moon");

        mTKAImageRes.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mTKANames.add("Havana");

        mTKAImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mTKANames.add("Senorita");

        mTKAImageRes.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mTKANames.add("On my Way");
    }

}
