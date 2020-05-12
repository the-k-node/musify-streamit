package com.example.musicplayerproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerproject.adapters.TrendRVAdapter;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {

    Toolbar toolbar;
    View myFragment;

    private ArrayList<Integer> mEngTrendsNumbers = new ArrayList<>();
    private ArrayList<String> mEngImageResources = new ArrayList<>();
    private ArrayList<Integer> mEngGradientRes = new ArrayList<>();

    private ArrayList<Integer> mHinTrendsNumbers = new ArrayList<>();
    private ArrayList<String> mHinImageResources = new ArrayList<>();
    private ArrayList<Integer> mHinGradientRes = new ArrayList<>();

    private ArrayList<Integer> mTelTrendsNumbers = new ArrayList<>();
    private ArrayList<String> mTelImageResources = new ArrayList<>();
    private ArrayList<Integer> mTelGradientRes = new ArrayList<>();

    private ArrayList<Integer> mKanTrendsNumbers = new ArrayList<>();
    private ArrayList<String> mKanImageResources = new ArrayList<>();
    private ArrayList<Integer> mKanGradientRes = new ArrayList<>();

    public TrendingFragment() {
        // Required empty public constructor
    }
    public TrendingFragment getInstance(){
        return new TrendingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_trending, container, false);

        toolbar = (Toolbar)myFragment.findViewById(R.id.custom_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initrecyclerViewEngTrending();
        initrecyclerViewHinTrending();
        initrecyclerViewTelTrending();
        initrecyclerViewKanTrending();

        return myFragment;
    }

    public void initrecyclerViewEngTrending() {
        initEngResources();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView = myFragment.findViewById(R.id.trend_rv_1);
        TrendRVAdapter adapter = new TrendRVAdapter(getActivity().getApplicationContext(), mEngTrendsNumbers, mEngImageResources, mEngGradientRes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void initEngResources() {
        Log.d(TAG, "initResources: called.");
        mEngImageResources.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mEngGradientRes.add(R.drawable.gradblue_cardbg);
        mEngTrendsNumbers.add(1);
        mEngImageResources.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mEngGradientRes.add(R.drawable.gradgreen_cardbg);
        mEngTrendsNumbers.add(2);
        mEngImageResources.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mEngGradientRes.add(R.drawable.gradyellow_cardbg);
        mEngTrendsNumbers.add(3);
        mEngImageResources.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mEngGradientRes.add(R.drawable.gradpurple_cardbg);
        mEngTrendsNumbers.add(4);
    }

    public void initrecyclerViewHinTrending() {
        initHinResources();
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView2 = myFragment.findViewById(R.id.trend_rv_2);
        TrendRVAdapter adapter2 = new TrendRVAdapter(getActivity().getApplicationContext(), mHinTrendsNumbers, mHinImageResources, mHinGradientRes);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(layoutManager2);
    }

    public void initHinResources() {
        Log.d(TAG, "initResources: called.");
        mHinImageResources.add("https://c.saavncdn.com/991/Genda-Phool-Hindi-2020-20200325120350-500x500.jpg");
        mHinGradientRes.add(R.drawable.gradyellow_cardbg);
        mHinTrendsNumbers.add(1);
        mHinImageResources.add("https://static.toiimg.com/thumb/msid-68426152,width-800,height-600,resizemode-75,imgsize-96150,pt-32,y_pad-40/68426152.jpg");
        mHinGradientRes.add(R.drawable.gradpurple_cardbg);
        mHinTrendsNumbers.add(2);
        mHinImageResources.add("https://c.saavncdn.com/962/Garmi-From-Street-Dancer-3D--Hindi-2019-20191226105651-500x500.jpg");
        mHinGradientRes.add(R.drawable.gradgreen_cardbg);
        mHinTrendsNumbers.add(3);
        mHinImageResources.add("https://m.media-amazon.com/images/M/MV5BMDRjZjQyOTQtNjFjNS00YThjLWJkODAtNTIyNDgyYTI0ZjkwXkEyXkFqcGdeQXVyMTA5NzIyMDY5._V1_.jpg");
        mHinGradientRes.add(R.drawable.gradblue_cardbg);
        mHinTrendsNumbers.add(4);
    }

    public void initrecyclerViewTelTrending() {
        initTelResources();
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView3 = myFragment.findViewById(R.id.trend_rv_3);
        TrendRVAdapter adapter3 = new TrendRVAdapter(getActivity().getApplicationContext(), mTelTrendsNumbers, mTelImageResources, mTelGradientRes);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(layoutManager3);
    }

    public void initTelResources() {
        Log.d(TAG, "initResources: called.");
        mTelImageResources.add("https://a10.gaanacdn.com/gn_img/song/a7LWBaz3zX/LWByQjgP3z/size_xxl_1578473536.webp");
        mTelGradientRes.add(R.drawable.gradpurple_cardbg);
        mTelTrendsNumbers.add(1);
        mTelImageResources.add("https://a10.gaanacdn.com/gn_img/song/01A3mar3NQ/A3mgeG7abN/size_xxl_1582086024.webp");
        mTelGradientRes.add(R.drawable.gradgreen_cardbg);
        mTelTrendsNumbers.add(2);
        mTelImageResources.add("https://naasongs.co/wp-content/uploads/2020/03/Vakeel-Saab-2020-Maguva-Maguva-250x250.jpg");
        mTelGradientRes.add(R.drawable.gradblue_cardbg);
        mTelTrendsNumbers.add(3);
        mTelImageResources.add("https://lyricsraag.com/wp-content/uploads/2020/03/Nee-Kannu-Neeli-Samudram-From-Uppena-Telugu-lyrics.jpg");
        mTelGradientRes.add(R.drawable.gradyellow_cardbg);
        mTelTrendsNumbers.add(4);
    }

    public void initrecyclerViewKanTrending() {
        initKanResources();
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView4 = myFragment.findViewById(R.id.trend_rv_4);
        TrendRVAdapter adapter4 = new TrendRVAdapter(getActivity().getApplicationContext(), mKanTrendsNumbers, mKanImageResources, mKanGradientRes);
        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(layoutManager4);
    }

    public void initKanResources() {
        Log.d(TAG, "initResources: called.");
        mKanImageResources.add("https://c.saavncdn.com/969/KGF-Original-Soundtrack-Vol-2-Kannada-2019-20200116125704-500x500.jpg");
        mKanGradientRes.add(R.drawable.gradgreen_cardbg);
        mKanTrendsNumbers.add(1);
        mKanImageResources.add("https://c.saavncdn.com/846/Avane-Srimannarayana-Kannada--Kannada-2019-20200102123542-500x500.jpg");
        mKanGradientRes.add(R.drawable.gradblue_cardbg);
        mKanTrendsNumbers.add(2);
        mKanImageResources.add("https://a10.gaanacdn.com/gn_img/albums/lJvKa63DV9/JvKayPX2KD/size_xxl_1582008184.webp");
        mKanGradientRes.add(R.drawable.gradpurple_cardbg);
        mKanTrendsNumbers.add(3);
        mKanImageResources.add("https://a10.gaanacdn.com/gn_img/albums/VdNW0Mbo5e/dNW0MpgXbo/size_xxl_1566816688.webp");
        mKanGradientRes.add(R.drawable.gradyellow_cardbg);
        mKanTrendsNumbers.add(4);
    }
}
