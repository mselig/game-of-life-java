package com.gol;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class GameOfLifeTest
{
    private GameOfLife game;


    @Test
    public void testConstructor()
    {
        game = new GameOfLife(new String[]{"1", "2", "3"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new GameOfLife(new String[]{"1", "2"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new GameOfLife(new String[]{"1"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new GameOfLife(null);
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new GameOfLife();
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
    }


    @Test
    public void testConstructorExceptions()
    {
        try
        {
            new GameOfLife(new String[]{"nan"});
            fail("expect: NumberFormatException");
        }
        catch(NumberFormatException exception)
        {
            assertEquals(exception.getMessage(), "For input string: \"nan\"");
        }
    }


    @Test
    public void testExampleGameofLife()
    {
        String output = new GameOfLife().evolve();
        assertEquals(output.startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"
                + "    []                \n"
                + "[]  []                \n"
                + "  [][]      [][][]    \n"
                + "                      \n"
                + "                      "), true);
        assertEquals(output.endsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 011\n"
                + "                      \n"
                + "            [][]      \n"
                + "          []  []      \n"
                + "          [][]        \n"
                + "                      "), true);
    }


    @Test
    public void testGameOfLife()
    {
        try
        {
            GameOfLife.main(null);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

}

