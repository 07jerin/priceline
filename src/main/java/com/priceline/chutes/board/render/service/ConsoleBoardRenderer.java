package com.priceline.chutes.board.render.service;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.player.Player;

public class ConsoleBoardRenderer implements BoardRender {
    @Override
    public void displayBoard(Board board) {
        // TODO:
        System.out.println("Display board");
    }

    @Override
    public void displayBoard(Board board, Player[] players) {
        //TODO:
        System.out.println("Display board with player positions");
    }
}
