package com.aiog.allinonegame;

import com.aiog.allinonegame.Pieces.Piece;

public class Positions {
    private Piece piece;


    Positions(Piece piece ) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;

    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

}