package com.priceline.chutes.board.creation.service;

import com.priceline.chutes.board.Board;

import java.util.Scanner;

public class ConsoleBoardLoader implements  BoardLoader{

    //TODO : Inject
    private  final BoardBuilder boardBuilder = new ConsoleBoardBuilder();

    @Override
    public Board createBoard() {
        System.out.println("Choose board --> ");
        System.out.println("1 : For Default Board");
        System.out.println("2 : For Random Board");
        System.out.println("3 : For Random custom board");


        Board board;
        Scanner scanner = new Scanner(System.in);
        int type  = Integer.parseInt(scanner.nextLine());
        BoardType boardType = BoardType.getBoardType(type);

        return boardType.getBoard(boardBuilder);
    }


}
