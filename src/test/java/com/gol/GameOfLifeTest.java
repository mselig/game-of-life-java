package com.gol;


import org.junit.Test;


public class GameOfLifeTest
{
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

