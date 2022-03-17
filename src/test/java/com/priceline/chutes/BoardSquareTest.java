package com.priceline.chutes;

import com.priceline.chutes.board.BoardSquare;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void aChuteShouldSkipSquaresReversed(){
        BoardSquare square = BoardSquare.buildChute(10);
        assertTrue(square.getNumberSquaresToSkip() < 0);
    }

    @RepeatedTest(3)
    public void checkSquaresToSkipForChute(){
        final  int squaresToSkip = new Random().nextInt(100);
        BoardSquare square = BoardSquare.buildChute(squaresToSkip);
        assertEquals(-1*squaresToSkip, square.getNumberSquaresToSkip());
    }


    @RepeatedTest(3)
    public void checkSquaresToSkipForLadder(){
        final  int squaresToSkip = new Random().nextInt(100);
        BoardSquare square = BoardSquare.buildLadder(squaresToSkip);
        assertEquals(squaresToSkip, square.getNumberSquaresToSkip());
    }

    @Test
    public void checkSquaresToSkipForPlainSquare(){
        assertEquals(0, BoardSquare.buildNormalSquare().getNumberSquaresToSkip());
    }
}
