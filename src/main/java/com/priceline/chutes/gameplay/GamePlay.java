package com.priceline.chutes.gameplay;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.board.render.service.BoardRender;
import com.priceline.chutes.player.Player;

public interface GamePlay {

    public Player playGame(Board board, Player[] players, BoardRender boardRender);


}
