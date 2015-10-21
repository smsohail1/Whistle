package com.example.appxone.whistle;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends Activity {

    InterstitialAd mInterstitialAd;
    Button mNewGameButton;
    AnimationDrawable a;
    ImageView whistle,animation_img;
    Animation whis;

MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
whistle= (ImageView) findViewById(R.id.whistle);

       animation_img= (ImageView) findViewById(R.id.animation_img1);



animation_img.setBackgroundResource(R.drawable.anim_list);
         // animation_img.setBackgroundResource(R.anim.animn);
        //animation_img.setBackgroundResource(R.anim.animaa);
        m = MediaPlayer.create(MainActivity.this, R.raw.whistle);
        whistle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(m.isPlaying()) {

//    m.release();
                    m.stop();
                    m.reset();
                    m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    //m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    // @Override
                    // public void onCompletion(MediaPlayer mp) {

                    //  }
                    //};
a.stop();
                    Toast toast=Toast.makeText(MainActivity.this,"Sound stopped",Toast.LENGTH_SHORT);
                    toast.show();

                }
                else
                {
                    //  m.seekTo(seek_pos);

//m.release();
//animation_img.startAnimation(whis);
               // a= (AnimationDrawable) animation_img.getDrawable();
                  //  a.start();
a= (AnimationDrawable) animation_img.getBackground();
                    a.start();
                    // m.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    m = MediaPlayer.create(MainActivity.this, R.raw.whistle);
                    //public void onPrepared(MediaPlayer mp) {
                    m.start();

                    //  }
                    //});

//m.setOnPreparedListener(MainActivity.this);

//    m.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//        public void onPrepared(MediaPlayer mp1) {
//            // mp1.start();
//            mp1.start();
//
//        }
//    });
                    //  m.start();
//    m.prepareAsync();

                    Toast toast=Toast.makeText(MainActivity.this,"Sound Play",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9381472359687969/8052217331");
//        mInterstitialAd.show();
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);

    }

}
