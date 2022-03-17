package com.priceline.chutes.gameplay;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.board.BoardSquare;
import com.priceline.chutes.board.render.service.BoardRender;
import com.priceline.chutes.player.Player;

import java.util.Random;
import java.util.Scanner;

public class ChutesConsoleGameplay implements  GamePlay{


    private static  final int MAX_SQUARE_SIZE = 100;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Player playGame(Board board, Player[] players, BoardRender boardRender) {
        while(true){
            for (Player currentPlayer : players) {
                int spinResult = getSpinResult(currentPlayer, board, players, boardRender);
                int nextPosition = currentPlayer.getPosition() + spinResult;
                System.out.println("You won " + spinResult + " --> moving to " + nextPosition);
                if (nextPosition > MAX_SQUARE_SIZE){
                    break;
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();

                System.out.println(ChutesConsoleGameplay.getNextSquareMessage(nextSquare) + " --> Moving to : " + nextPosition);

                if (nextPosition < MAX_SQUARE_SIZE) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == MAX_SQUARE_SIZE) {
                    return currentPlayer;
                }
            }
        }
    }

    private static String getNextSquareMessage(BoardSquare boardSquare){
        StringBuilder sb = new StringBuilder("You are on ");
        if(boardSquare.getIsChute()){
            sb.append("Chute ! ");
            sb.append("Please move by ");
            sb.append(boardSquare.getNumberSquaresToSkip());

        }else if(boardSquare.getIsLadder()){
            sb.append("Ladder ! ");
            sb.append("Please move by ");
            sb.append(boardSquare.getNumberSquaresToSkip());
        }else{
            sb.append("normal square");
        }

        return  sb.toString();
    }


    private int getSpinResult(Player currentPlayer, Board board, Player[] players, BoardRender boardRender) {
        System.out.println("-------------------------------");
        System.out.println(currentPlayer.getName() + " in position : " +  currentPlayer.getPosition()+ ", to play. Press 'P' to show current positions, or any other key to spin");
        String value = scanner.nextLine();
        if("P".equalsIgnoreCase(value)){
            boardRender.displayBoard(board, players);
            System.out.println(currentPlayer.getName() + " : press any key to spin");
            value = scanner.nextLine();
        }
        int spinResult = spin();
        return spinResult;
    }

    private int spin(){
        return random.nextInt(6) + 1;
    }
}
