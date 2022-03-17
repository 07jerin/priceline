package com.priceline.chutes.board;

import java.util.List;

public class Board {

    private final String name;
    private final List<BoardSquare> squares;
    public BoardSquare getSquareAtPosition(int i){
        return squares.get(i-1);
    }

    public Board(String name, List<BoardSquare> squares){
        this.name = name;
        this.squares = squares;
    }
}
