package com.priceline.chutes;

public class BoardSquare {
    private final boolean isChute;
    private final boolean isLadder;
    private final int numberSquaresToSkip;

    BoardSquare(){
        this(false, false, 0);
    }

    private BoardSquare(boolean isChute, boolean isLadder, int numberSquaresToSkip){
        this.isChute = isChute;
        this.isLadder = isLadder;
        this.numberSquaresToSkip = numberSquaresToSkip;
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
