package com.gol;


public class GameOfLife
{
    public static void main(String[] arguments) throws Exception
    {
        System.out.println((new Game(arguments)).evolve());
    }

}

