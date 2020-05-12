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
import com.example.musicplayerproject.adapters.AllRecyclerViewAdapter;
import com.example.musicplayerproject.adapters.AllRecyclerViewAdapterforCircle;
import com.example.musicplayerproject.adapters.AllRecyclerViewLanguageAdapter;

import java.util.ArrayList;

public class AllFragment extends Fragment {

    private static final String TAG = "AllFragment";

    private ArrayList<String> mEngNames = new ArrayList<>();
    private ArrayList<String> mEngImageUrls = new ArrayList<>();
    private ArrayList<String> mHisNames = new ArrayList<>();
    private ArrayList<String> mHisImageUrls = new ArrayList<>();
    private ArrayList<String> mHinNames = new ArrayList<>();
    private ArrayList<String> mHinImageUrls = new ArrayList<>();
    private ArrayList<String> mLangNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    View view;

    public static AllFragment getInstance(){
        return new AllFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_allfragment, container, false);
        initRecyclerViewHis();
        initRecyclerViewLang();
        initRecyclerViewPopEng();
        initRecyclerViewPopHin();
        return view;
    }

    private void initRecyclerViewHis(){

        initImageBitmapsHis();
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView2 = view.findViewById(R.id.all_rv_1);
        AllRecyclerViewAdapterforCircle adapter2 = new AllRecyclerViewAdapterforCircle(getActivity().getApplicationContext(),mHisNames,mHisImageUrls);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(layoutManager2);
    }

    private void initRecyclerViewLang(){
        initImageBitmapsLang();
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView2 = view.findViewById(R.id.all_rv_2);
        AllRecyclerViewLanguageAdapter adapter2 = new AllRecyclerViewLanguageAdapter(getActivity().getApplicationContext(),mLangNames,mImageResources);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(layoutManager2);
    }

    private void initRecyclerViewPopEng(){
        initImageBitmapsPopEng();
        Log.d(TAG, "initRecyclerView: init recylerview");

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView3 = view.findViewById(R.id.all_rv_3);
        AllRecyclerViewAdapter adapter3 = new AllRecyclerViewAdapter(getActivity().getApplicationContext(),mEngNames,mEngImageUrls);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(layoutManager3);

    }

    private void initRecyclerViewPopHin(){
        initImageBitmapsPopHin();
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView4 = view.findViewById(R.id.all_rv_4);
        AllRecyclerViewAdapter adapter4 = new AllRecyclerViewAdapter(getActivity().getApplicationContext(),mHinNames,mHinImageUrls);
        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(layoutManager4);
    }

    private void initImageBitmapsHis(){
        //Pass all the urls for history from here
        Log.d(TAG, "initImageBitmaps: preparing history bitmaps.");

        mHisImageUrls.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mHisNames.add("Shape of You");

        mHisImageUrls.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mHisNames.add("Dark Side of Moon");

        mHisImageUrls.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mHisNames.add("Havana");

        mHisImageUrls.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mHisNames.add("Despacito");

        mHisImageUrls.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mHisNames.add("Cheap Thrills");

        mHisImageUrls.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mHisNames.add("Taki Taki");

        mHisImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mHisNames.add("Senorita");

        mHisImageUrls.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mHisNames.add("On my Way");
    }

    private void initImageBitmapsLang(){
        mImageResources.add(R.drawable.gradblue_cardbg);
        mLangNames.add("English");
        mImageResources.add(R.drawable.gradgreen_cardbg);
        mLangNames.add("Hindi");
        mImageResources.add(R.drawable.gradpurple_cardbg);
        mLangNames.add("Telugu");
        mImageResources.add(R.drawable.gradyellow_cardbg);
        mLangNames.add("Kannada");
    }

    private void initImageBitmapsPopEng(){
        //Pass all the urls for popular english from here
        Log.d(TAG, "initImageBitmaps: preparing english bitmaps.");

        mEngImageUrls.add("https://i1.sndcdn.com/artworks-000174898618-vsdrz9-t500x500.jpg");
        mEngNames.add("Cheap Thrills");

        mEngImageUrls.add("https://upload.wikimedia.org/wikipedia/en/8/8b/Taki_Taki_%28Official_Single_Cover%29_-_DJ_Snake.png");
        mEngNames.add("Taki Taki");

        mEngImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png/220px-Shawn_Mendes_and_Camila_Cabello_-_Se%C3%B1orita.png");
        mEngNames.add("Senorita");

        mEngImageUrls.add("https://ar.toneden.io/28002570/tracks/temp5123?cache=1561827330250");
        mEngNames.add("On my Way");

        mEngImageUrls.add("https://4.bp.blogspot.com/-YocR1HiG45k/WbYfCQF9wMI/AAAAAAAAACE/YmnGk99fW1s7Ln45CvAlHHo1duEFcM5vgCLcBGAs/s1600/Ed%2BSheeran%2B-%2B%25C3%25B7%2B%2528Divide%2529%2B%2528Deluxe%2529%2B%25282017%2529.jpg");
        mEngNames.add("Shape of You");

        mEngImageUrls.add("https://i.insider.com/57e42475077dcca2018b7944?width=750&format=jpeg&auto=webp");
        mEngNames.add("Dark Side of Moon");

        mEngImageUrls.add("https://cdn.smehost.net/sonymusiccomau-auprod/wp-content/uploads/Havanna-Album-Artwork.jpeg");
        mEngNames.add("Havana");

        mEngImageUrls.add("https://upload.wikimedia.org/wikipedia/en/c/c8/Luis_Fonsi_Feat._Daddy_Yankee_-_Despacito_%28Official_Single_Cover%29.png");
        mEngNames.add("Despacito");

    }

    private void initImageBitmapsPopHin(){
        //Pass all the urls for Popular hindi from here
        Log.d(TAG, "initImageBitmaps: preparing hindi bitmaps.");

        mHinImageUrls.add("https://c.saavncdn.com/991/Genda-Phool-Hindi-2020-20200325120350-500x500.jpg");
        mHinNames.add("Ghenda Phool");

        mHinImageUrls.add("https://static.toiimg.com/thumb/msid-68426152,width-800,height-600,resizemode-75,imgsize-96150,pt-32,y_pad-40/68426152.jpg");
        mHinNames.add("Teri Mitti");

        mHinImageUrls.add("https://media-images.mio.to/various_artists/P/Pati%20Patni%20Aur%20Woh%20%282019%29/Art-350.jpg");
        mHinNames.add("Ankhiyon Se Goli..");

        mHinImageUrls.add("https://a10.gaanacdn.com/gn_img/song/7rVW1Rbk56/VW1evp65Wk/size_xxl_1570445948.webp");
        mHinNames.add("Shaitan ka Saala");

        mHinImageUrls.add("https://m.media-amazon.com/images/M/MV5BMDRjZjQyOTQtNjFjNS00YThjLWJkODAtNTIyNDgyYTI0ZjkwXkEyXkFqcGdeQXVyMTA5NzIyMDY5._V1_.jpg");
        mHinNames.add("Pachtaoge");

        mHinImageUrls.add("https://c.saavncdn.com/962/Garmi-From-Street-Dancer-3D--Hindi-2019-20191226105651-500x500.jpg");
        mHinNames.add("Garmi");

        mHinImageUrls.add("https://a10.gaanacdn.com/gn_img/song/0wrb4N3Lg7/rb4ed0PNKL/size_xxl_1567659563.webp");
        mHinNames.add("Ghungroo");

        mHinImageUrls.add("https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/23/78/26/23782668-a6f9-34bb-15b3-e32c89ae26ab/source/1200x1200bb.jpg");
        mHinNames.add("Dheeme Dheeme");
    }


}
