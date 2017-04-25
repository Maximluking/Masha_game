package com.maximluking.masha_game;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends Activity
    {

        private Thread mSplashThread;
        private MediaPlayer mp;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
            mp = MediaPlayer.create(this, R.raw.splash);
            mp.setLooping(true);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
                {
                    public void onPrepared(MediaPlayer mp)
                    {
                       mp.start();
                    }
                });

            //Анимация сплеша
            final ImageView splashImageView = (ImageView) findViewById(R.id.splashImageView);
            splashImageView.setBackgroundResource(R.drawable.splashscreen);
            final AnimationDrawable frameAnimation = (AnimationDrawable) splashImageView.getBackground();
            splashImageView.post(new Runnable()
                {
                    @Override
                    public void run()
                        {
                            frameAnimation.start();
                        }
                });
            final SplashScreen sPlashScreen = this;
            mSplashThread = new Thread()
                {
                    @Override
                    public void run()
                        {
                            try
                                {
                                    synchronized (this)
                                        {
                                            // Wait given period of time or exit on touch
                                            wait(5000);
                                        }
                                }
                            catch (InterruptedException ex)
                                {
                                }
                            // Запускаес MainActivity
                            Intent intent = new Intent();
                            intent.setClass(sPlashScreen, MainActivity.class);
                            startActivity(intent);
                            frameAnimation.stop();
                            mp.release();
                            finish();
                        }
                };
            mSplashThread.start();
        }

                /*@Override // сброс анимации и переход в MainActivity при косании
                public boolean onTouchEvent(MotionEvent evt)
                {
                    if (evt.getAction() == MotionEvent.ACTION_DOWN)
                     {
                        synchronized (mSplashThread)
                        {
                            mSplashThread.notifyAll();
                        }
                     }
                    return true;
                }*/

    }