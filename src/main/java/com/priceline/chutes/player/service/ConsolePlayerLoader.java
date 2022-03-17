package com.priceline.chutes.player.service;

import com.priceline.chutes.player.Player;

import java.io.Console;
import java.util.Scanner;

public class ConsolePlayerLoader implements  PlayerLoader {

    @Override
    public Player[] loadPlayers() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of player (between 2- 4 ): ");
        int count = Integer.parseInt(scanner.nextLine());

        //TODO : Validations
        Player[] players = getPlayers(scanner, count);
        return players;
    }

    private Player[] getPlayers(Scanner scanner, int count) {
        System.out.println("Enter the players : ");
        Player[] players = new Player[count];
        for (int i = 0; i< count; i++){
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }
        return players;
    }
}
