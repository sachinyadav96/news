package com.c.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends Activity {
    TextView txtAppName;
    private Animation slide_up, slide_up1;
    private Handler handler2;

    Runnable csRunnable1 = new Runnable() {
        @Override
        public void run() {
            txtAppName.startAnimation(slide_up);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        PrefrenceServices.init(this);
        slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        txtAppName = findViewById(R.id.txtAppName);
        Handler handler1 = new Handler();
        handler1.postDelayed(csRunnable1, 0);
        slide_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtAppName.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(() -> {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
