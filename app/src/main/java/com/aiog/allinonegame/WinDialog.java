package com.aiog.allinonegame;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinDialog extends Dialog {
    public final TicTacToe ticTacToe;
    private final String message;
    Button go_back;

    public WinDialog(Context context, String message2) {
        super(context);
        this.message = message2;
        this.ticTacToe = (TicTacToe) context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
        ((TextView) findViewById(R.id.msgTextView)).setText(this.message);
        ((Button) findViewById(R.id.startAgainBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WinDialog.this.ticTacToe.startMatchAgain();
                WinDialog.this.dismiss();
            }
        });
        ((Button) findViewById(R.id.go_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WinDialog.this.ticTacToe.goToGameList();
                WinDialog.this.dismiss();
            }
        });
    }
}
