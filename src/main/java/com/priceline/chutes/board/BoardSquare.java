package com.priceline.chutes.board;

public class BoardSquare {
    private final boolean isChute;
    private final boolean isLadder;
    private final int numberSquaresToSkip;


    private BoardSquare(boolean isChute, boolean isLadder, int numberSquaresToSkip){
        this.isChute = isChute;
        this.isLadder = isLadder;
        this.numberSquaresToSkip = numberSquaresToSkip;
    }

    public  static BoardSquare buildNormalSquare(){
        return  new BoardSquare(false, false, 0);
    }

    public static BoardSquare buildChute(int numberSquaresToSkip){
        return new BoardSquare(true, false, numberSquaresToSkip);
    }

    public static BoardSquare buildLadder(int numberSquaresToSkip){
        return new BoardSquare(false, true, numberSquaresToSkip);
    }

    public int getNumberSquaresToSkip() {
        if (isLadder) {
            return numberSquaresToSkip;
        } else if (isChute) {
            return numberSquaresToSkip * -1;
        } else {
            return 0;
        }
    }
}
