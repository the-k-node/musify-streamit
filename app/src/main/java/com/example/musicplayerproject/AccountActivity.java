package com.example.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton mAccScreenKnowusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.darkBlue));
        initView();
    }

    public void backIconClickedAccount(View v) {
        onBackPressed();
    }

    private void initView() {
        mAccScreenKnowusBtn = (MaterialButton) findViewById(R.id.acc_screen_knowus_btn);
        mAccScreenKnowusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acc_screen_knowus_btn:
                startActivity(new Intent(this,CreditsActivity.class));
                break;
        }
    }
}
