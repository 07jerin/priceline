package com.priceline.chutes;

import com.priceline.chutes.board.Board;
import com.priceline.chutes.board.creation.service.BoardType;
import com.priceline.chutes.board.creation.service.ConsoleBoardBuilder;
import com.priceline.chutes.board.render.service.ConsoleBoardRenderer;
import com.priceline.chutes.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConsoleBoardRenderTest {

    private static Player[] players;
    @BeforeAll
    public static void createPlayers(){
        players = new Player[] {
                new Player("Jerin", 80),
                new Player("Staphy" , 19),
                new Player("Mark" , 55),
                new Player("Sixty" , 60),
                new Player("Sixty One" , 61),
                new Player("Sixty Nine" , 69),
                new Player("Mark Dup", 55),
                new Player("Zero", 0),
        };
    }


    @Test
    public void testBoardRenderWithPlayers(){
        Board board = BoardType.DEFAULT.getBoard(new ConsoleBoardBuilder());
        new ConsoleBoardRenderer().displayBoard(board, ConsoleBoardRenderTest.players);
    }

    @Test
    public void testBoardRender(){
        Board board = BoardType.DEFAULT.getBoard(new ConsoleBoardBuilder());
        new ConsoleBoardRenderer().displayBoard(board);
    }
}
