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

import com.example.musicplayerproject.adapters.RecentPlaysRVAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyMusicFragment extends Fragment {

    Toolbar toolbar;
    View myFragment;
    private ArrayList<String> mRPText = new ArrayList<>();
    private ArrayList<String> mRPImageRes = new ArrayList<>();
    private ArrayList<Integer> mRPGradRes = new ArrayList<>();

    public static MyMusicFragment getInstance(){
        return new MyMusicFragment();
    }

    public MyMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_mymusic, container, false);
        toolbar = (Toolbar)myFragment.findViewById(R.id.custom_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        initRecyclerRecentPlaysView();
        // Inflate the layout for this fragment
        return myFragment;
    }

    public void initRecyclerRecentPlaysView() {
        initImageResView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = myFragment.findViewById(R.id.recent_plays_RV);
        RecentPlaysRVAdapter adapter = new RecentPlaysRVAdapter(getActivity().getApplicationContext(),mRPText,mRPImageRes, mRPGradRes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void initImageResView() {
        mRPImageRes.add("https://a10.gaanacdn.com/gn_img/song/a7LWBaz3zX/LWByQjgP3z/size_xxl_1578473536.webp");
        mRPGradRes.add(R.drawable.gradblue_cardbg);
        mRPText.add("ButtaBomma");
        mRPImageRes.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mRPGradRes.add(R.drawable.gradgreen_cardbg);
        mRPText.add("Genda\nPhool");
        mRPImageRes.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mRPGradRes.add(R.drawable.gradpurple_cardbg);
        mRPText.add("Dheeme\nDheeeme");
        mRPImageRes.add("https://c.saavncdn.com/991/Genda-Phool-Hindi-2020-20200325120350-500x500.jpg");
        mRPGradRes.add(R.drawable.gradyellow_cardbg);
        mRPText.add("Genda\nPhool");
        mRPImageRes.add("https://m.media-amazon.com/images/M/MV5BMDRjZjQyOTQtNjFjNS00YThjLWJkODAtNTIyNDgyYTI0ZjkwXkEyXkFqcGdeQXVyMTA5NzIyMDY5._V1_.jpg");
        mRPGradRes.add(R.drawable.gradblue_cardbg);
        mRPText.add("Pachtaoge");
        mRPImageRes.add("https://c.saavncdn.com/969/KGF-Original-Soundtrack-Vol-2-Kannada-2019-20200116125704-500x500.jpg");
        mRPGradRes.add(R.drawable.gradgreen_cardbg);
        mRPText.add("K.G.F.");
    }
}
