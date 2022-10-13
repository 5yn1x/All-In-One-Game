package com.aiog.allinonegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TttPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttt_player);

        final EditText playerOne =findViewById(R.id.playerOne);
        final EditText playerTwo =findViewById(R.id.playerTwo);
        ((AppCompatButton) findViewById(R.id.startGameBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String playerOneName = playerOne.getText().toString();
                String playerTwoName = playerTwo.getText().toString();
                if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
                    Toast.makeText(TttPlayer.this, "Please Enter Player Names", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(TttPlayer.this, TicTacToe.class);
                intent.putExtra("playerOne", playerOneName);
                intent.putExtra("playerTwo", playerTwoName);
                TttPlayer.this.startActivity(intent);
                finish();
            }
        });
    }
}