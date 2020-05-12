package com.example.musicplayerproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SidharthaProfileActivity extends AppCompatActivity {

    ImageButton cross_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidhartha_profile);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.orange));

        cross_button = findViewById(R.id.cross_btn);
        cross_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void sidhInstaProfile(View view){
        Uri uri = Uri.parse("http://instagram.com/sidhartha_sekhar_127");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/sidhartha_sekhar_127")));
        }
    }

    public void sidhWaProfile(View view){
        String url = "https://api.whatsapp.com/send?phone=+918114613927";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void sidhFbProfile(View view){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/sidhartha.sekhar.52"));
            startActivity(intent);
        } catch(Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/sidhartha.sekhar.52")));
        }
    }
    public void sidhLinkedProfile(View view){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sidhartha-sekhar"));
            intent.setPackage("com.linkedin.android");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sidhartha-sekhar")));
        }
    }

}
