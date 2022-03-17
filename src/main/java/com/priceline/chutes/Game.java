package com.priceline.chutes;

import com.priceline.chutes.board.*;
import com.priceline.chutes.board.creation.service.BoardLoader;
import com.priceline.chutes.board.creation.service.ConsoleBoardLoader;
import com.priceline.chutes.board.render.service.BoardRender;
import com.priceline.chutes.board.render.service.ConsoleBoardRenderer;
import com.priceline.chutes.gameplay.ChutesConsoleGameplay;
import com.priceline.chutes.gameplay.GamePlay;
import com.priceline.chutes.player.Player;
import com.priceline.chutes.player.service.ConsolePlayerLoader;
import com.priceline.chutes.player.service.PlayerLoader;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    // TODO: load based on runtime configuration or DI
    private final PlayerLoader playerLoader = new ConsolePlayerLoader();
    private final BoardLoader boardLoader = new ConsoleBoardLoader();
    private final BoardRender boardRender = new ConsoleBoardRenderer();
    private final GamePlay gamePlay = new ChutesConsoleGameplay();


    private Player[] players;
    private Board board;

    public void setUpGame() {
        System.out.println("Create players -------------------> ");
        this.players = playerLoader.loadPlayers();
        System.out.println("Welcome " + Arrays.toString(players));

        System.out.println("Set up board -------------------> ");
        this.board = boardLoader.createBoard();
        boardRender.displayBoard(this.board);
    }

    public Player playGame() {
        this.setUpGame();
        return this.startGame();
    }

    private Player startGame() {
        return gamePlay.playGame(this.board, this.players, this.boardRender);

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
