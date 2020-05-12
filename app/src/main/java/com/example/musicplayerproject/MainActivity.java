package com.example.musicplayerproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar bottomNavBar;
    FragmentManager fragmentManager;
    private static final String TAG = MainActivity.class.getSimpleName();

    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBottomSheet;
    private ToggleButton tbUpDown, tbPLayPause;
    RelativeLayout bottomMusicPlayerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavBar = findViewById(R.id.bottom_nav_bar);

        if(savedInstanceState==null){
            bottomNavBar.setItemSelected(R.id.home_menu,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,homeFragment).commit();
        }

        initView();

        tbUpDown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        Window w = getWindow();
                        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                    }
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    Window w = getWindow();
                    w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                }

            }
        });
        tbPLayPause.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(),"Playing",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Paused",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Window w = getWindow();
                if(newState == BottomSheetBehavior.STATE_EXPANDED){
                    bottomMusicPlayerLayout.setVisibility(View.GONE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                    }
                }else{
                    bottomMusicPlayerLayout.setVisibility(View.VISIBLE);
                    tbUpDown.setChecked(false);
                    w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                 }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });

        bottomNavBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.home_menu:
                        fragment = new HomeFragment();
                        break;
                    case R.id.songs_menu:
                        fragment = new PlaylistsFragment();
                        break;
                    case R.id.albums_menu:
                        fragment = new TrendingFragment();
                        break;
                    case R.id.playlists_menu:
                        fragment = new MyMusicFragment();
                        break;
                }
                if(fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
                }else{
                    Log.e(TAG,"Error Creating Fragment");
                }
            }
        });
    }

    private void initView() {
        this.linearLayoutBottomSheet = findViewById(R.id.bottomSheet);
        this.bottomSheetBehavior = bottomSheetBehavior.from(linearLayoutBottomSheet);
        this.tbUpDown = findViewById(R.id.music_player_up_down);
        this.tbPLayPause = findViewById(R.id.music_player_play_pause);
        this.bottomMusicPlayerLayout = findViewById(R.id.bottomMusicPlayerBar);
    }

    public void displayPictureAccount(View view){
        startActivity(new Intent(this,AccountActivity.class));
    }
    public void searchOperation(View view){
        startActivity(new Intent(this,SearchActivity.class));
    }
}
