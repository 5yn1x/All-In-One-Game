package com.aiog.allinonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends AppCompatActivity {

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final List<int[]> combinationsList = new ArrayList();
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private LinearLayout player1Layout;
    private TextView player1Name;
    private LinearLayout player2Layout;
    private TextView player2Name;
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        this.player1Layout = findViewById(R.id.player1Layout);
        this.player2Layout = findViewById(R.id.player2Layout);
        this.player1Name = findViewById(R.id.player1TV);
        this.player2Name = findViewById(R.id.player2TV);
        this.image1 = findViewById(R.id.image1);
        this.image2 = findViewById(R.id.image2);
        this.image3 = findViewById(R.id.image3);
        this.image4 = findViewById(R.id.image4);
        this.image5 = findViewById(R.id.image5);
        this.image6 = findViewById(R.id.image6);
        this.image7 = findViewById(R.id.image7);
        this.image8 = findViewById(R.id.image8);
        this.image9 = findViewById(R.id.image9);
        this.combinationsList.add(new int[]{0, 1, 2});
        this.combinationsList.add(new int[]{3, 4, 5});
        this.combinationsList.add(new int[]{6, 7, 8});
        this.combinationsList.add(new int[]{0, 3, 6});
        this.combinationsList.add(new int[]{1, 4, 7});
        this.combinationsList.add(new int[]{2, 5, 8});
        this.combinationsList.add(new int[]{2, 4, 6});
        this.combinationsList.add(new int[]{0, 4, 8});
        String playerOneName = getIntent().getStringExtra("playerOne");
        String playerTwoName = getIntent().getStringExtra("playerTwo");
        this.player1Name.setText(playerOneName);
        this.player2Name.setText(playerTwoName);
        this.image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(0)) {
                    TicTacToe.this.performAction((ImageView) v, 0);
                }
            }
        });
        this.image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(1)) {
                    TicTacToe.this.performAction((ImageView) v, 1);
                }
            }
        });
        this.image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(2)) {
                    TicTacToe.this.performAction((ImageView) v, 2);
                }
            }
        });
        this.image4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(3)) {
                    TicTacToe.this.performAction((ImageView) v, 3);
                }
            }
        });
        this.image5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(4)) {
                    TicTacToe.this.performAction((ImageView) v, 4);
                }
            }
        });
        this.image6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(5)) {
                    TicTacToe.this.performAction((ImageView) v, 5);
                }
            }
        });
        this.image7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(6)) {
                    TicTacToe.this.performAction((ImageView) v, 6);
                }
            }
        });
        this.image8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(7)) {
                    TicTacToe.this.performAction((ImageView) v, 7);
                }
            }
        });
        this.image9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TicTacToe.this.isBoxSelectable(8)) {
                    TicTacToe.this.performAction((ImageView) v, 8);
                }
            }
        });
    }

    public void performAction(ImageView imageView, int selectedBoxPosition) {
        int[] iArr = this.boxPositions;
        int i = this.playerTurn;
        iArr[selectedBoxPosition] = i;
        if (i == 1) {
            imageView.setImageResource(R.drawable.ironman);
            if (checkPlayerWin()) {
                new WinDialog(this, this.player1Name.getText().toString() + " has won the game").show();
            } else if (this.totalSelectedBoxes == 9) {
                new WinDialog(this, "It is a Draw!").show();
            } else {
                changePlayerTurn(2);
                this.totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.captainamerica);
            if (checkPlayerWin()) {
                WinDialog winDialog = new WinDialog(this, this.player2Name.getText().toString() + " has won the game");
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (this.totalSelectedBoxes == 9) {
                WinDialog winDialog2 = new WinDialog(this, "It is a Draw!");
                winDialog2.setCancelable(false);
                winDialog2.show();
            } else {
                changePlayerTurn(1);
                this.totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        this.playerTurn = currentPlayerTurn;
        if (currentPlayerTurn == 1) {
            this.player1Layout.setBackgroundResource(R.color.purple_700);
            this.player2Layout.setBackgroundResource(R.drawable.transparent_back);
            return;
        }
        this.player2Layout.setBackgroundResource(R.color.purple_700);
        this.player1Layout.setBackgroundResource(R.drawable.transparent_back);
    }

    /* access modifiers changed from: private */
    public boolean isBoxSelectable(int boxPosition) {
        if (this.boxPositions[boxPosition] == 0) {
            return true;
        }
        return false;
    }

    private boolean checkPlayerWin() {
        boolean response = false;
        for (int i = 0; i < this.combinationsList.size(); i++) {
            int[] combination = this.combinationsList.get(i);
            int[] iArr = this.boxPositions;
            int i2 = iArr[combination[0]];
            int i3 = this.playerTurn;
            if (i2 == i3 && iArr[combination[1]] == i3 && iArr[combination[2]] == i3) {
                response = true;
            }
        }
        return response;
    }

    public void startMatchAgain() {
        this.boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.playerTurn = 1;
        this.totalSelectedBoxes = 1;
        this.image1.setImageResource(R.drawable.transparent_back);
        this.image2.setImageResource(R.drawable.transparent_back);
        this.image3.setImageResource(R.drawable.transparent_back);
        this.image4.setImageResource(R.drawable.transparent_back);
        this.image5.setImageResource(R.drawable.transparent_back);
        this.image6.setImageResource(R.drawable.transparent_back);
        this.image7.setImageResource(R.drawable.transparent_back);
        this.image8.setImageResource(R.drawable.transparent_back);
        this.image9.setImageResource(R.drawable.transparent_back);
    }
    public void goToGameList(){
        Intent intent = new Intent(TicTacToe.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}