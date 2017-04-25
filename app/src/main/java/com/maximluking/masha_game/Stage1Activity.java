package com.maximluking.masha_game;
import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class Stage1Activity extends Activity implements View.OnClickListener
{
    ImageButton ram;
    ImageButton parrot;
    ImageButton penguin;
    ImageButton hen;
    ImageButton cow;
    ImageButton squirrel;
    ImageButton hippo;
    ImageButton kangaroo;
    ImageButton lion;


    public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.stage1splash);

            new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                        {
                            setContentView(R.layout.stage1);
                        }
                }, 2000);


            ram = (ImageButton)findViewById(R.id.ram);
            parrot = (ImageButton)findViewById(R.id.parrot);
            penguin = (ImageButton)findViewById(R.id.penguin);
            hen = (ImageButton)findViewById(R.id.hen);
            cow = (ImageButton)findViewById(R.id.cow);
            squirrel = (ImageButton)findViewById(R.id.squirrel);
            hippo = (ImageButton)findViewById(R.id.hippo);
            kangaroo = (ImageButton)findViewById(R.id.kangaroo);
            lion = (ImageButton)findViewById(R.id.lion);







        }

    @Override
    public void onClick(View v) {

    }
}
