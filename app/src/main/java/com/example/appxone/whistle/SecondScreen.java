package com.example.appxone.whistle;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;

/**
 * Created by APPXONE on 9/29/2015.
 */
public class SecondScreen extends Activity {


    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;
    InterstitialAd mInterstitialAd;
    Button mNewGameButton;
    AnimationDrawable a;
    int duration;
    ImageView whistle1,animation_img;
    Animation whis;
    MediaPlayer m;
    Timer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity);
        initControls();
        whistle1= (ImageView) findViewById(R.id.whistles2);



       //animation_img= (ImageView) findViewById(R.id.animation_img1);

        // animation_img.set
        //   whis= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animaa);
        //whistle.setBackgroundResource(R.drawable.anim_list);
        // animation_img.setBackgroundResource(R.anim.animn);
        //animation_img.setBackgroundResource(R.anim.animaa);
        m = MediaPlayer.create(SecondScreen.this, R.raw.whistle);
        whistle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(m.isPlaying()) {

//    m.release();

                    m.stop();
                    m.setLooping(false);
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
                   // time.cancel();
                    //sohail
                   // whistle1.setBackground(null);
//whistle1.setImageDrawable(null);
                  // a=null;

                    whistle1.setBackgroundResource(R.drawable.pressed_whislte2);
                  //  whistle.setImageResource(R.mipmap.white_background);
                  // whistle1.setImageResource(R.mipmap.whistle02);

                }
                else
                {
                    //  m.seekTo(seek_pos);
//m.release();
//animation_img.startAnimation(whis);
                    // a= (AnimationDrawable) animation_img.getDrawable();
                    //  a.start();
                  //  whistle.setVisibility(View.INVISIBLE);

                /* Create an Intent that will start the Menu-Activity. */

                /* Create an Intent that will start the Menu-Activity. */
                    //sohail
                            //whistle1.setBackground(null);
                    whistle1.setImageDrawable(null);
                            // m.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                            m = MediaPlayer.create(SecondScreen.this, R.raw.whistle);
                    m.setLooping(true);
                            //public void onPrepared(MediaPlayer mp) {
                            m.start();
                            whistle1.setBackgroundResource(R.drawable.anim_list);
                            a = (AnimationDrawable) whistle1.getBackground();
                            a.start();
//                            if (m.isPlaying()) {
//
//
//                                time=new Timer();
//                                time.schedule(new TimerTask() {
//                                    @Override
//                                    public void run() {
//
//a.stop();
//                                        m.stop();
//                                        runOnUiThread(new Runnable() {
//                                            @Override
//                                            public void run() {
//
//                                                whistle1.setBackgroundResource(R.mipmap.whistle02);
//                                            }
//                                        });
//
//                                        time.cancel();
//                                    }
//                                },1800);
//                            }








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

                }
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9381472359687969/2105781736");
//        mInterstitialAd.show();
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);
    }
    private void initControls() {
        try {
            volumeSeekbar = (SeekBar) findViewById(R.id.seekBar);
            volumeSeekbar.setProgress(100);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {


                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                                    progress, 0);


                   // audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_VIBRATE | AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if(m.isPlaying()) {
            m.stop();
        }


        SecondScreen.this.finish();

        super.onBackPressed();
    }

    @Override
    protected void onUserLeaveHint() {
        if(m.isPlaying()) {
            m.stop();
        }


            SecondScreen.this.finish();

        super.onUserLeaveHint();
    }
}
