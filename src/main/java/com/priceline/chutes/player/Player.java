package com.priceline.chutes.player;

import java.lang.annotation.Documented;

public class Player {

    private final String name;
    private int position;

    public Player(String name){
        this.name = name;
    }

    public Player(String name, int position){
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public  String toString(){
        return getName() + " in position : " + getPosition();
    }
}
