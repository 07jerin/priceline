package com.priceline.chutes.board.render.service;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.board.BoardSquare;
import com.priceline.chutes.player.Player;

import java.util.Arrays;

public class ConsoleBoardRenderer implements BoardRender {
    @Override
    public void displayBoard(Board board) {
        String[][] strBoard = new String[10][10];
        populateStrBoard(board, strBoard);
        printBoard(strBoard);
    }

    @Override
    public void displayBoard(Board board, Player[] players) {
        String[][] strBoard = new String[10][10];
        populateStrBoard(board, strBoard);
        populatePlayers(players, strBoard);
        printBoard(strBoard);

    }

    private void printBoard(String[][] strBoard) {
        for (int i = 9; i >= 0; i--) {
            StringBuilder rowBuilder = new StringBuilder();
            if (i % 2 == 0) {
                for (int j = 0; j < 10; j++) {
                    rowBuilder.append(strBoard[i][j]);
                    rowBuilder.append("  ||  ");
                }
            } else {
                for (int j = 9; j >= 0; j--) {
                    rowBuilder.append(strBoard[i][j]);
                    rowBuilder.append("  ||  ");
                }
            }
            System.out.println(rowBuilder);

        }
    }

    private void populatePlayers(Player[] players, String[][] strBoard) {
        for (Player player : players) {
            int position = player.getPosition() - 1;
            if (position == -1) continue;

            int row = position / 10;
            int col = position % 10;

            strBoard[row][col] += "," + player.getName();
        }
    }

    private void populateStrBoard(Board board, String[][] strBoard) {
        int offset = 0;
        for (String[] row : strBoard) {
            for (int i = 0; i < 10; i++) {
                int position = i + offset + 1;
                BoardSquare boardSquare = board.getSquareAtPosition(position);
                StringBuilder suffix = new StringBuilder(position + "");
                if (boardSquare.getIsLadder()) {
                    suffix.append("(Ladder +");
                    suffix.append(boardSquare.getNumberSquaresToSkip());
                    suffix.append(")");
                } else if (boardSquare.getIsChute()) {
                    suffix.append("(Chute ");
                    suffix.append(boardSquare.getNumberSquaresToSkip());
                    suffix.append(")");
                } else {
                    suffix.append("  ");
                }
                row[i] = suffix.toString();
            }
            offset += 10;
        }
    }
}
