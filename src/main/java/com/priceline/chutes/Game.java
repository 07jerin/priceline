package com.priceline.chutes;

import com.priceline.chutes.board.*;
import com.priceline.chutes.board.creation.service.BoardLoader;
import com.priceline.chutes.board.creation.service.ConsoleBoardLoader;
import com.priceline.chutes.player.Player;
import com.priceline.chutes.player.service.ConsolePlayerLoader;
import com.priceline.chutes.player.service.PlayerLoader;

import java.util.Arrays;
import java.util.Random;

public class Game {

    private final Random random = new Random();
    // TODO: load based on runtime configuration or DI
    private final PlayerLoader playerLoader = new ConsolePlayerLoader();
    private final BoardLoader boardLoader = new ConsoleBoardLoader();

    private Player[] players;
    private Board board;

    public void setUpGame(){
        System.out.println("Create players -------------------> ");
        this.players = playerLoader.loadPlayers();
        System.out.println("Welcome " + Arrays.toString(players));

        System.out.println("Set up board -------------------> ");
        this.board = boardLoader.createBoard();
    }

    public Player playGame(){
        this.setUpGame();


        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > 100){
                    break;
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                if (nextPosition < 100) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == 100) {
                    return currentPlayer;//The winner!
                }
            }
        }
    }

    private int spin(){
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        try {
            Player winner = new Game().playGame();

            System.out.println("The winner is: " + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
