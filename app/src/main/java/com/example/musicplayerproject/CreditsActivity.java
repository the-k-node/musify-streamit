package com.example.musicplayerproject;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreditsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton back;
    private CircleImageView mCreditsSidharthaProfPicTV;
    private TextView mCreditsSidharthaNameTV;
    private TextView mCreditsSidharthaDescTV;
    private RelativeLayout mCreditsSidharthaListLayout;
    private CircleImageView mCreditsKiranProfPicTV;
    private TextView mCreditsKiranNameTV;
    private TextView mCreditsKiranDescTV;
    private RelativeLayout mCreditsKiranListLayout;
    private CircleImageView mCreditsShreyaProfPicTV;
    private TextView mCreditsShreyaNameTV;
    private TextView mCreditsShreyaDescTV;
    private RelativeLayout mCreditsShreyaListLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        initView();

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.orange));

        back = findViewById(R.id.credits_screen_back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    private void initView() {
        mCreditsSidharthaProfPicTV = (CircleImageView) findViewById(R.id.credits_sidhartha_profPicTV);
        mCreditsSidharthaNameTV = (TextView) findViewById(R.id.credits_sidhartha_nameTV);
        mCreditsSidharthaDescTV = (TextView) findViewById(R.id.credits_sidhartha_descTV);
        mCreditsSidharthaListLayout = (RelativeLayout) findViewById(R.id.credits_sidhartha_ListLayout);
        mCreditsSidharthaListLayout.setOnClickListener(this);
        mCreditsKiranProfPicTV = (CircleImageView) findViewById(R.id.credits_kiran_profPicTV);
        mCreditsKiranNameTV = (TextView) findViewById(R.id.credits_kiran_nameTV);
        mCreditsKiranDescTV = (TextView) findViewById(R.id.credits_kiran_descTV);
        mCreditsKiranListLayout = (RelativeLayout) findViewById(R.id.credits_kiran_ListLayout);
        mCreditsKiranListLayout.setOnClickListener(this);
        mCreditsShreyaProfPicTV = (CircleImageView) findViewById(R.id.credits_shreya_profPicTV);
        mCreditsShreyaNameTV = (TextView) findViewById(R.id.credits_shreya_nameTV);
        mCreditsShreyaDescTV = (TextView) findViewById(R.id.credits_shreya_descTV);
        mCreditsShreyaListLayout = (RelativeLayout) findViewById(R.id.credits_shreya_ListLayout);
        mCreditsShreyaListLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.credits_sidhartha_ListLayout:
                Pair[] pairs0 = new Pair[3];
                pairs0[0] = new Pair<View, String>(mCreditsSidharthaProfPicTV, "credits_sidhartha_imageTransition");
                pairs0[1] = new Pair<View, String>(mCreditsSidharthaNameTV, "credits_sidhartha_nameTV");
                pairs0[2] = new Pair<View, String>(mCreditsSidharthaDescTV, "credits_sidhartha_descTV");

                ActivityOptions options0 = null;
                options0 = ActivityOptions.makeSceneTransitionAnimation(CreditsActivity.this, pairs0);
                startActivity(new Intent(CreditsActivity.this, SidharthaProfileActivity.class), options0.toBundle());
                break;
            case R.id.credits_kiran_ListLayout:
                Pair[] pairs1 = new Pair[3];
                pairs1[0] = new Pair<View, String>(mCreditsKiranProfPicTV, "credits_kiran_imageTransition");
                pairs1[1] = new Pair<View, String>(mCreditsKiranNameTV, "credits_kiran_nameTV");
                pairs1[2] = new Pair<View, String>(mCreditsKiranDescTV, "credits_kiran_descTV");

                ActivityOptions options1 = null;
                options1 = ActivityOptions.makeSceneTransitionAnimation(CreditsActivity.this, pairs1);
                startActivity(new Intent(CreditsActivity.this, KiranProfileActivity.class), options1.toBundle());
                break;
            case R.id.credits_shreya_ListLayout:
                Pair[] pairs2 = new Pair[3];
                pairs2[0] = new Pair<View, String>(mCreditsShreyaProfPicTV, "credits_shreya_imageTransition");
                pairs2[1] = new Pair<View, String>(mCreditsShreyaNameTV, "credits_shreya_nameTV");
                pairs2[2] = new Pair<View, String>(mCreditsShreyaDescTV, "credits_shreya_descTV");

                ActivityOptions options2 = null;
                options2 = ActivityOptions.makeSceneTransitionAnimation(CreditsActivity.this, pairs2);
                startActivity(new Intent(CreditsActivity.this, ShreyaProfileActivity.class), options2.toBundle());
                break;
            default:
                Toast.makeText(getApplicationContext(), "Click on a proper card to view their details",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
