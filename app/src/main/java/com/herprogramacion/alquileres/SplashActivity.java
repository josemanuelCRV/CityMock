package com.herprogramacion.alquileres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by josem on 26/09/2016.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);


        /*Intent i;     i = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(i);
        finish();*/
        /**
         * Acceso a SharedPreferences para realizar el redireccionamiento.
         * */
        //final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i;
                        i = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                }, 200); //splash


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
