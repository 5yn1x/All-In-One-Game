package com.aiog.allinonegame;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiog.allinonegame.ai.RandomAIPlayer;
import com.aiog.allinonegame.model.HumanPlayer;
import com.aiog.allinonegame.model.Player;
import com.aiog.allinonegame.view.GameView;
import com.aiog.allinonegame.view.PlayersStateView;

import java.util.Map;

public class DotsAndBoxes extends AppCompatActivity implements PlayersStateView {

    protected GameView gameView;
    protected TextView player1name, player2name, player1state, player2state, player1occupying,
            player2occupying;
    ImageView currentPlayerPointer;
    Player[] players;
    Integer[] playersOccupying = new Integer[]{0, 0};
    Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button restartGame;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots_and_boxes);

        gameView = findViewById(R.id.gameView);
        gameView.setPlayersState(this);

        player1name = (TextView) findViewById(R.id.player1name);
        player2name = (TextView) findViewById(R.id.player2name);
        player1state = (TextView) findViewById(R.id.player1state);
        player2state = (TextView) findViewById(R.id.player2state);
        player1occupying = (TextView) findViewById(R.id.player1occupying);
        player2occupying = (TextView) findViewById(R.id.player2occupying);
        currentPlayerPointer = (ImageView) findViewById(R.id.playerNowPointer);

        players = new Player[]{new HumanPlayer("Human"), new RandomAIPlayer("Computer")};
        startGame(players);

        restartGame = findViewById(R.id.restartGame);
        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DotsAndBoxes.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void startGame(Player[] players) {
        gameView.startGame(players);
        updateState();
    }

    public void updateState() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (currentPlayer == players[0]) {
                    player1state.setText("Thinking");
                    player2state.setText("Waiting");
                    currentPlayerPointer.setImageResource(R.drawable.a1);
                } else if (currentPlayer == players[1]) {
                    player2state.setText("Thinking");
                    player1state.setText("Waiting");
                    currentPlayerPointer.setImageResource(R.drawable.a2);
                }
                player1occupying.setText("Occupying " + playersOccupying[0]);
                player2occupying.setText("Occupying " + playersOccupying[1]);
            }
        });
    }

    @Override
    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        updateState();
    }

    @Override
    public void setPlayerOccupyingBoxesCount(Map<Player, Integer> player_occupyingBoxesCount_map) {
        playersOccupying[0] = (player_occupyingBoxesCount_map.get(players[0]));
        playersOccupying[1] = (player_occupyingBoxesCount_map.get(players[1]));
        updateState();
    }

    @Override
    public void setWinner(final Player winner) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(DotsAndBoxes.this)
                        .setTitle("Dots And Boxes")
                        .setMessage(winner.getName() + " Wins!")
                        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                recreate();
                            }
                        })
                        .setNeutralButton("Go To Game List", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(DotsAndBoxes.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    };
}
