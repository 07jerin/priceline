package com.priceline.chutes;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.board.creation.service.BoardType;
import com.priceline.chutes.board.creation.service.ConsoleBoardBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardCreationTest {

    @Test
    public void createDefaultBoard(){
        Board board =  BoardType.DEFAULT.getBoard(new ConsoleBoardBuilder());
        assertNotNull(board.getSquareAtPosition(100));
    }

    @Test
    public void createCustomBoard(){
        Board board =  BoardType.CUSTOM.getBoard(new ConsoleBoardBuilder());
        assertNotNull(board.getSquareAtPosition(100));
    }

    @Test
    public void createRandomBoard(){
        Board board =  BoardType.RANDOM.getBoard(new ConsoleBoardBuilder());
        assertNotNull(board.getSquareAtPosition(100));
    }
}
