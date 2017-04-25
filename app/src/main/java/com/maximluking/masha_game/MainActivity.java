package com.maximluking.masha_game;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends Activity
{

    private ImageButton button;
    private Animation mFadeInAnimation, mFadeOutAnimation;
    private MediaPlayer mp;
    private boolean flagforbutton;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!flagforbutton)
                {
                    flagforbutton = true;
                    button.setImageResource(R.drawable.but2);
                    button.getAnimation().cancel();
                    button.clearAnimation();
                    mFadeInAnimation.setAnimationListener(null);
                    mFadeOutAnimation.setAnimationListener(null);

                        new Handler().postDelayed(new Runnable()
                            {
                                @Override
                                public void run()
                                    {
                                        Intent menu = new Intent(MainActivity.this, Stage1Activity.class);
                                        startActivity(menu);
                                        mp.release();
                                    }
                            }, 1500);

                }

            }
        });

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein); // блок анимации для кнопки
        mFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        mFadeOutAnimation.setAnimationListener(animationFadeOutListener);
        button.startAnimation(mFadeOutAnimation);

        mp = MediaPlayer.create(this, R.raw.abc);
        mp.setLooping(true);//Звук будет проигрываться в цикле.
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
            {
                public void onPrepared(MediaPlayer mp)
                {
                   mp.start();
                }
            });

    }

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener()
        {

            @Override
            public void onAnimationEnd(Animation animation)
                {
                    button.startAnimation(mFadeInAnimation);
                }

            @Override
            public void onAnimationRepeat(Animation animation)
                {
                    // TODO Auto-generated method stub
                }

            @Override
            public void onAnimationStart(Animation animation)
                {
                    // TODO Auto-generated method stub
                }
        };

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation animation)
                {
                    button.startAnimation(mFadeOutAnimation);
                }

            @Override
            public void onAnimationRepeat(Animation animation)
                {
                    // TODO Auto-generated method stub
                }

            @Override
                public void onAnimationStart(Animation animation)
                {
                    // TODO Auto-generated method stub
                }
        };

}