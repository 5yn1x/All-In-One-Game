package com.aiog.allinonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

        ImageButton button1, button2, button3, button4, button5, button6, button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TttPlayer.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RockPaperScissors.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DotsAndBoxes.class);
                startActivity(intent);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Chessgame.class);
                startActivity(intent);
            }
        });

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random generator = new Random();
                int number = generator.nextInt(4) + 1;

                Class activity = null;

                switch (number){
                    case 1:
                        activity = TttPlayer.class;
                        break;

                    case 2:
                        activity = RockPaperScissors.class;
                        break;

                    case 3:
                        activity = DotsAndBoxes.class;
                        break;

                    default:
                        activity = Chessgame.class;
                        break;
                }

                Intent intent = new Intent(getBaseContext(), activity);
                startActivity(intent);
            }
        });

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

       button7 = findViewById(R.id.button7);
       button7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:allinonegame.aiog@gmail.com")));
           }
       });
    }
}