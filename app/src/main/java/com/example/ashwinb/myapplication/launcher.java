package com.example.ashwinb.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;
//Launcher With splash screen
public class launcher extends AwesomeSplash {


    private static int SPLASH_TIME_OUT = 3000;
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        /*new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            /*@Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(launcher.this, home.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);*/


    @Override
    public void initSplash(ConfigSplash configSplash) {
        ActionBar action=getSupportActionBar();
               // action.hide();
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                configSplash.setBackgroundColor(R.color.bg_splash);
                configSplash.setAnimCircularRevealDuration(3000);
                configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
                configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);
                //=[configSplash.setLogoSplash(R.drawable.picture1);
                configSplash.setAnimLogoSplashDuration(5000);
                configSplash.setAnimLogoSplashTechnique(Techniques.Bounce);

    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(launcher.this,home.class));
    }
}
