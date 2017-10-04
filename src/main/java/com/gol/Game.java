package com.gol;

import com.gol.base.Grid;
import com.gol.base.TwoDimensionalGrid;

public class Game
{
    private static final int defaultNumberOfCycles = 11;
    private static final int[][] exampleCells = new int[][]
            {
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };

    private int cycles;
    private Grid grid;


    public Game()
    {
        this.cycles = defaultNumberOfCycles;
        this.grid = new TwoDimensionalGrid(exampleCells);
    }


    public Game(String[] arguments) throws NumberFormatException
    {
        this();
        if(arguments != null)
        {
            switch(arguments.length)
            {
                case 3:
                    cycles      = Integer.parseInt(arguments[2]);
                case 2:
                    int rows    = Integer.parseInt(arguments[0]);
                    int columns = Integer.parseInt(arguments[1]);
                    grid        = new TwoDimensionalGrid(rows, columns);
                    break;
                case 1:
                    cycles      = Integer.parseInt(arguments[0]);
                default:
                    break;
            }
        }
    }


    public String evolve()
    {
        return evolve(cycles);
    }


    public String evolve(int numberOfCycles)
    {
        String output = grid.toString();
        for(int ii = 0; ii < numberOfCycles; ++ii)
        {
            output += "\n" + grid.evolve().toString();
        }
        return output;
    }

}

