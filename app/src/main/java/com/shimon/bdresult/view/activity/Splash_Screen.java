package com.shimon.bdresult.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shimon.bdresult.Login;
import com.shimon.bdresult.Login_Page;
import com.shimon.bdresult.R;

public class Splash_Screen extends AppCompatActivity {

    private ImageView appLogo;
    private TextView appTitle,appTagline;
    Animation topAnim,bottomAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Initialize();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash_Screen.this, Login_Page.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        },2000);

    }

    private void Initialize() {

        appLogo = findViewById(R.id.app_logoIV);
        appTitle = findViewById(R.id.app_TitleTV);
        appTagline = findViewById(R.id.app_tagLineTV);

        topAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_animation);

        appLogo.setAnimation(topAnim);
        appTitle.setAnimation(bottomAnim);
        appTagline.setAnimation(bottomAnim);
    }
}