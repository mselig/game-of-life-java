package com.gol.base;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class TwoDimensionalGridTest
{
    private TwoDimensionalGrid grid;


    @Test
    public void testSizeConstructor()
    {
        grid = new TwoDimensionalGrid(       1, 9);
        assertEquals(grid.getNumberOfRows(), 1);
        assertEquals(grid.getNumberOfColumns(), 9);
        grid = new TwoDimensionalGrid(       5, 7);
        assertEquals(grid.getNumberOfRows(), 5);
        assertEquals(grid.getNumberOfColumns(), 7);
    }


    @Test
    public void testSizeConstructorExceptions()
    {
        try
        {
            new TwoDimensionalGrid(0, 1);
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "non-positive 'numberOfRows': 0");
        }
        try
        {
            new TwoDimensionalGrid(1, 0);
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "non-positive 'numberOfColumns': 0");
        }
    }


    @Test
    public void testArrayConstructor()
    {
        int[][] cells = new int[][]
                {
                    {0, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0},
                    {1, 0, 1, 0, 1}
                };
        grid = new TwoDimensionalGrid(cells);
        assertEquals(grid.getNumberOfRows(),    3);
        assertEquals(grid.getNumberOfColumns(), 5);
    }


    @Test
    public void testArrayConstructorExceptions()
    {
        try
        {
            new TwoDimensionalGrid(null);
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "'cells' is null");
        }
        try
        {
            new TwoDimensionalGrid(new int[][]{});
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "zero rows");
        }
        try
        {
            new TwoDimensionalGrid(new int[][]{{}, {} , {}});
            fail("expect: IllegalArgumentException");
        }
        catch(IllegalArgumentException exception)
        {
            assertEquals(exception.getMessage(), "zero columns");
        }
    }


    @Test
    public void testGridEvolutionCycle()
    {
        grid = new TwoDimensionalGrid(1, 1);
        assertEquals(grid.getEvolutionCycle(),          0);
        assertEquals(grid.evolve().getEvolutionCycle(), 1);
    }


    @Test
    public void testGridEquals()
    {
        int[][] cells = new int[][]
                {
                    {0, 0, 0},
                    {0, 0, 0}
                };
        grid = new TwoDimensionalGrid(cells).evolve();
        assertEquals(grid.equals(null),                          false);
        assertEquals(grid.equals(cells),                         false);
        assertEquals(grid.equals(new TwoDimensionalGrid(cells)), true);
                cells = new int[][]
                {
                    {0, 0, 0},
                    {0, 0, 1}
                };
        assertEquals(grid.equals(new TwoDimensionalGrid(cells)), false);
        assertEquals(grid.equals(new TwoDimensionalGrid(1, 2)),  false);
        assertEquals(grid.equals(new TwoDimensionalGrid(1, 3)),  false);
        assertEquals(grid.equals(new TwoDimensionalGrid(2, 2)),  false);
    }


    @Test
    public void testEvolutionByStaticTub()
    {
        int[][] cells = new int[][]
                {
                    {0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0}
                };
        grid = new TwoDimensionalGrid(cells).evolve();
        assertEquals(new TwoDimensionalGrid(cells), grid);
    }


    @Test
    public void testEvolutionByPeriodicToad()
    {
        int[][] cells = new int[][]
                {
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0},
                    {0, 1, 0, 0, 1, 0},
                    {0, 1, 0, 0, 1, 0},
                    {0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0}
                };
        grid = new TwoDimensionalGrid(cells).evolve();
                cells = new int[][]
                {
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 1, 0},
                    {0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0}
                };
        assertEquals(new TwoDimensionalGrid(cells), grid);
    }


    @Test
    public void testEvolutionByGlider()
    {
        int[][] cells = new int[][]
                {
                    {0, 0, 1, 0, 0},
                    {1, 0, 1, 0, 0},
                    {0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0}
                };
        grid = new TwoDimensionalGrid(cells)
                .evolve().evolve().evolve().evolve().evolve()
                .evolve().evolve().evolve().evolve().evolve()
                .evolve().evolve().evolve().evolve().evolve()
                .evolve().evolve().evolve().evolve().evolve();
        assertEquals(new TwoDimensionalGrid(cells), grid);
    }


    @Test
    public void testToString()
    {
        int[][] cells = new int[][]{{0}};
        assertEquals(new TwoDimensionalGrid(cells).toString().startsWith(""
                + "--------------------------------------------------------------------------------\n"
                + "evolution cycle: 000\n"), true);
    }

}

