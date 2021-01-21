package com.example.trumpnukes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView text;
    ImageView image;
    TextView text2;
    TextView under;
    Button off;
    Button box;
    Button reset;
    MediaPlayer player;
    int score = 0;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bt = (Button) findViewById(R.id.launcher);
        box = (Button) findViewById(R.id.box);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.counter);
        text2 = (TextView) findViewById(R.id.king);
        under = (TextView) findViewById(R.id.gifttext);
        image = (ImageView) findViewById(R.id.imageView);
        off = (Button) findViewById(R.id.mute);

        //play song

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rocket);
        final MediaPlayer player = MediaPlayer.create(this, R.raw.dum);
        final MediaPlayer present = MediaPlayer.create(this, R.raw.ipresent);
        final MediaPlayer hmm = MediaPlayer.create(this, R.raw.hmm);
        final MediaPlayer newlevel = MediaPlayer.create(this, R.raw.newlevel);


        player.setLooping(true);
        player.start();
        player.setVolume(0.3f,0.3f);






        //load in the score

        SharedPreferences myScore = this.getSharedPreferences("MyScore", Context.MODE_PRIVATE);
        score = myScore.getInt("Score" ,0);


        text.setText("Nukes:  " + score);


        //my button listener

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                image.setVisibility(View.VISIBLE);

                mp.start();
                mp.setVolume(0.3f,0.3f);

                score++;

                SharedPreferences myScore = getSharedPreferences("MyScore",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("Score", score);
                editor.commit();

                text.setText("Nukes:  " + score);

                if(score==31) {
                    text2.setText( "A Gift Has Appeared");
                    box.setVisibility(View.VISIBLE);
                }

                if (score==49) {
                    text2.setText( "NOOB +10");
                    score+=10;
                    newlevel.start();
                    newlevel.setVolume(0.3f,0.3f);
                }

                if (score==99) {
                    text2.setText( "Hmm +50");
                    score+=50;
                    newlevel.start();
                    newlevel.setVolume(0.3f,0.3f);
                }

                if (score==299) {
                    text2.setText( "LEVEL 2");
                    text2.setTextColor(Color.parseColor("#1966e3"));
                    score+=50;
                    newlevel.start();
                    newlevel.setVolume(0.3f,0.3f);
                }

                if (score==499) {
                    text2.setText( "Come On You Can Do Better Right +100?");
                    score+=100;
                    newlevel.start();
                    newlevel.setVolume(0.3f,0.3f);
                }
                if(score==545) {
                    text2.setText( "A Gift Has Appeared");
                    box.setVisibility(View.VISIBLE);
                    newlevel.start();
                    newlevel.setVolume(0.3f,0.3f);
                }

                if (score==999) {
                    text2.setText( "Interesting +500");
                    score+=500;
                }
                if (score==2999) {
                    text2.setText( "LEVEL 3");
                    text2.setTextColor(Color.parseColor("#07ed76"));
                    score+=500;
                }
                if(score==3500) {
                    text2.setText( "A Gift Has Appeared");
                    box.setVisibility(View.VISIBLE);
                }

                if (score==4999) {
                    text2.setText( "WOW +1000");
                    score+=1000;
                }

                if (score==9999) {
                    text2.setText( "WOW You Are Amazing +5000");
                    score+=5000;
                }

                if(score==15000) {
                    text2.setText( "A Gift Has Appeared");
                    box.setVisibility(View.VISIBLE);
                }

                if (score==29999) {
                    text2.setText( "LEVEL 4");
                    text2.setTextColor(Color.parseColor("#e5ed07"));
                    score+=5000;
                }

                if (score==49999) {
                    text2.setText( "YOU ARE A GOD +10000");
                    score+=10000;
                }

                if (score==99999) {
                    text2.setText( "RIP Your GirlFriend +50000");
                    score+=50000;
                }
                if (score==29999) {
                    text2.setText( "LEVEL 5");
                    text2.setTextColor(Color.parseColor("#ed2a07"));
                    score+=50000;
                }

                if (score==499999) {
                    text2.setText( "Are You Modded? +100000");
                    score+=100000;
                }

            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.isPlaying()){
                    player.pause();
                    off.setBackgroundResource(R.drawable.on);
                }else {
                    player.start();
                    off.setBackgroundResource(R.drawable.mute);
                }

            }
        });

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                present.start();
                present.setVolume(0.3f,0.3f);

                try {
                    score+=500;
                    Thread.sleep(300);
                    box.setVisibility(View.GONE);
                    text2.setText( "LEVEL 2");
                    under.setText( "You Opened The Gift +500");

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

    }
    });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hmm.start();
                hmm.setVolume(0.3f,0.3f);

                score=0;
                text2.setText( "UHH My Nukes Are Gone");
                box.setVisibility(View.GONE);

            }
        });

}
}