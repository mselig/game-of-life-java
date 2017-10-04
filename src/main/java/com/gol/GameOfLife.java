package com.gol;


abstract class GameOfLife
{
    public static void main(String[] arguments) throws Exception
    {
        System.out.println((new Game(arguments)).evolve());
    }

}

