package com.gol;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class GameTest
{
    private Game game;


    @Test
    public void testConstructor()
    {
        game = new Game(new String[]{"1", "2", "3"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new Game(new String[]{"1", "2"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new Game(new String[]{"1"});
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new Game(null);
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
        game = new Game();
        assertEquals(game.evolve(0).startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
    }


    @Test
    public void testConstructorExceptions()
    {
        try
        {
            new Game(new String[]{"nan"});
            fail("expect: NumberFormatException");
        }
        catch(NumberFormatException exception)
        {
            assertEquals(exception.getMessage(), "For input string: \"nan\"");
        }
    }


    @Test
    public void testExampleGame()
    {
        game = new Game();
        assertEquals(game.evolve().endsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 011\n"
                + "                      \n"
                + "            [][]      \n"
                + "          []  []      \n"
                + "          [][]        \n"
                + "                      "), true);
    }

}

