package com.priceline.chutes.board.render.service;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.player.Player;

public interface BoardRender {

    public  void displayBoard(Board board);
    public  void displayBoard(Board board, Player[] players);
}
