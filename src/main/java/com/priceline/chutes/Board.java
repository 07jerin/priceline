package com.priceline.chutes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.entry;

public class Board {

    private static final Map<Integer, BoardSquare> SPECIAL_SQUARES = Map.ofEntries(
            entry(1, BoardSquare.buildLadder(37)),
            entry(4, BoardSquare.buildLadder(10)),
            entry(9, BoardSquare.buildLadder(22)),
            entry(16, BoardSquare.buildChute(10)),
            entry(21, BoardSquare.buildLadder(21)),
            entry(28, BoardSquare.buildLadder(56)),
            entry(36, BoardSquare.buildLadder(8)),
            entry(47, BoardSquare.buildChute(21)),
            entry(49, BoardSquare.buildChute(38)),
            entry(51, BoardSquare.buildLadder(16)),
            entry(56, BoardSquare.buildChute(3)),
            entry(62, BoardSquare.buildChute(43)),
            entry(64, BoardSquare.buildChute(4)),
            entry(71, BoardSquare.buildLadder(20)),
            entry(80, BoardSquare.buildLadder(20)),
            entry(87, BoardSquare.buildChute(63)),
            entry (93, BoardSquare.buildChute(20)),
            entry(95, BoardSquare.buildChute(20)),
            entry(98, BoardSquare.buildChute(20))
    );

    private final List<BoardSquare> squares;


    Board() {
        squares = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Optional
                        .ofNullable(Board.SPECIAL_SQUARES.get(i))
                        .orElseGet(BoardSquare::new))
                .collect(Collectors.toList());
    }

    BoardSquare getSquareAtPosition(int i){
        return squares.get(i-1);
    }

}
