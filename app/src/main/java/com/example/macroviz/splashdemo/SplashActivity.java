package com.example.macroviz.splashdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {
    private LinearLayout logo;
    private ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation fadeIn = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);

        logo = findViewById(R.id.logo);
        pic = findViewById(R.id.pic);
        logo.setAnimation(fadeIn);
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in);

                }
            }
        };
        timer.start();
    }
}
