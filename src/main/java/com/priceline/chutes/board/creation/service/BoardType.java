package com.priceline.chutes.board.creation.service;

import com.priceline.chutes.board.Board;

public enum BoardType {

    DEFAULT(1) {
        public Board getBoard(BoardBuilder builder) {
            return builder.buildDefaultBoard();
        }

    }, RANDOM(2) {
        public Board getBoard(BoardBuilder builder) {
            return builder.buildRandomBoard();
        }

    }, CUSTOM(3) {
        public Board getBoard(BoardBuilder builder) {
            return builder.buildCustomBoard();
        }

    };

    BoardType(int type) {
    }

    public static BoardType getBoardType(int type) {
        switch (type) {
            case 1:
                return BoardType.DEFAULT;
            case 2:
                return BoardType.RANDOM;
            case 3:
                return BoardType.CUSTOM;
            default:
                System.out.println("Invalid choice falling back to default");
        }
        return BoardType.DEFAULT;
    }

    public abstract Board getBoard(BoardBuilder builder);
}
