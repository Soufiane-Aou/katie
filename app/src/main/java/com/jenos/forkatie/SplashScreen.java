package com.jenos.forkatie;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;


public class SplashScreen extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3500)
                .withBackgroundResource(R.color.colorPrimaryDark)
                .withFooterText("Created by Soufiane")
                .withBeforeLogoText("Learn Arabic")
                .withAfterLogoText("This app designed for katerina")
                .withLogo(R.drawable.logo_app_splash);


        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        //finally create the view
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
