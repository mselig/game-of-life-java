package com.gol.base;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PrimitiveCellTest
{
    @Test
    public void testBooleanConstructor()
    {
        assertEquals((new PrimitiveCell(true)).isAlive(),  true);
        assertEquals((new PrimitiveCell(false)).isAlive(), false);
    }


    @Test
    public void testIntegerConstructor()
    {
        assertEquals((new PrimitiveCell(+1)).isAlive(), true);
        assertEquals((new PrimitiveCell( 0)).isAlive(), false);
        assertEquals((new PrimitiveCell(-1)).isAlive(), true);
    }


    @Test
    public void testEvolutionOfLiveCellByRule1()
    {
        // 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
        assertEquals((new PrimitiveCell(true)).evolve(Integer.MIN_VALUE).isAlive(), false);
        assertEquals((new PrimitiveCell(true)).evolve(1).isAlive(),                 false);
    }

    @Test
    public void testEvolutionOfLiveCellByRule2()
    {
        // 2. Any live cell with two or three live neighbours lives on to the next generation.
        assertEquals((new PrimitiveCell(true)).evolve(2).isAlive(),                 true);
        assertEquals((new PrimitiveCell(true)).evolve(3).isAlive(),                 true);
    }


    @Test
    public void testEvolutionOfLiveCellByRule3()
    {
        // 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
        assertEquals((new PrimitiveCell(true)).evolve(4).isAlive(),                 false);
        assertEquals((new PrimitiveCell(true)).evolve(Integer.MAX_VALUE).isAlive(), false);
    }


    @Test
    public void testEvolutionOfDeadCellByRule4()
    {
        // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        assertEquals((new PrimitiveCell(false)).evolve(Integer.MIN_VALUE).isAlive(), false);
        assertEquals((new PrimitiveCell(false)).evolve(2).isAlive(),                 false);
        assertEquals((new PrimitiveCell(false)).evolve(3).isAlive(),                 true);
        assertEquals((new PrimitiveCell(false)).evolve(4).isAlive(),                 false);
        assertEquals((new PrimitiveCell(false)).evolve(Integer.MAX_VALUE).isAlive(), false);
    }


    @Test
    public void testToString()
    {
        assertEquals((new PrimitiveCell(true )).toString(), "[]");
        assertEquals((new PrimitiveCell(false)).toString(), "  ");
    }

}

