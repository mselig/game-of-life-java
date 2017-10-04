package com.gol.base;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class CellTest
{
    private final Cell liveCell = new Cell(true);
    private final Cell deadCell = new Cell(false);


    @Test
    public void testBooleanConstructor()
    {
        assertEquals((new Cell(true)).isAlive(),  true);
        assertEquals((new Cell(false)).isAlive(), false);
    }


    @Test
    public void testIntegerConstructor()
    {
        assertEquals((new Cell(+1)).isAlive(), true);
        assertEquals((new Cell( 0)).isAlive(), false);
        assertEquals((new Cell(-1)).isAlive(), true);
    }


    @Test
    public void testRefreshOfRandomCell()
    {
        Cell cell  = new Cell();
        assertEquals(cell.getNumberOfLivingNeighbours(),                                                                       0);
        assertEquals(cell.refresh(new Cell[]{}).getNumberOfLivingNeighbours(),                                                 0);
        assertEquals(cell.refresh(new Cell[]{deadCell, liveCell}).getNumberOfLivingNeighbours(),                               1);
        assertEquals(cell.refresh(new Cell[]{deadCell, liveCell, deadCell, liveCell, liveCell}).getNumberOfLivingNeighbours(), 3);
    }


    @Test
    public void testRefreshExceptions()
    {
        try
        {
            (new Cell()).refresh(null);
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "'neighbours' is null");
        }
    }


    @Test
    public void testEvolutionOfLiveCellByRule1()
    {
        // 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        assertEquals((new Cell(true)).evolve(Integer.MIN_VALUE).isAlive(), false);
        assertEquals((new Cell(true)).evolve(1).isAlive(),                 false);
    }

    @Test
    public void testEvolutionOfLiveCellByRule2()
    {
        // 2. Any live cell with two or three live neighbours lives on to the next generation.
        assertEquals((new Cell(true)).evolve(2).isAlive(),                 true);
        assertEquals((new Cell(true)).evolve(3).isAlive(),                 true);
    }


    @Test
    public void testEvolutionOfLiveCellByRule3()
    {
        // 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
        assertEquals((new Cell(true)).evolve(4).isAlive(),                 false);
        assertEquals((new Cell(true)).evolve(Integer.MAX_VALUE).isAlive(), false);
    }


    @Test
    public void testEvolutionOfDeadCellByRule4()
    {
        // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        assertEquals((new Cell(false)).evolve(Integer.MIN_VALUE).isAlive(), false);
        assertEquals((new Cell(false)).evolve(2).isAlive(),                 false);
        assertEquals((new Cell(false)).evolve(3).isAlive(),                 true);
        assertEquals((new Cell(false)).evolve(4).isAlive(),                 false);
        assertEquals((new Cell(false)).evolve(Integer.MAX_VALUE).isAlive(), false);
    }

}

