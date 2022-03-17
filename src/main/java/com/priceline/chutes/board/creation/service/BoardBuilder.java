package com.priceline.chutes.board.creation.service;

import com.priceline.chutes.board.Board;

public interface BoardBuilder {

    Board buildDefaultBoard();
    Board buildRandomBoard();
    Board buildCustomBoard();
}
