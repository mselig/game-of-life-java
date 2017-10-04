package com.gol;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class GameOfLifeTest
{
    @Test
    public void testConstructorExceptions()
    {
        try
        {
            GameOfLife.main(new String[]{"nan"});
            fail("expect: NumberFormatException");
        }
        catch(NumberFormatException exception)
        {
            assertEquals(exception.getMessage(), "For input string: \"nan\"");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

}

