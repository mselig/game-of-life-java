package com.gol;

import com.gol.base.TwoDimensionalGrid;

public class GameOfLife
{
    private static final int[][] canoe11 = new int[][]
            {
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            };

    private static int numberOfCycles = 11;


    public static void main(String[] args)
    {
        TwoDimensionalGrid grid = new TwoDimensionalGrid(canoe11);
        switch(args.length)
        {
            case 3:
                numberOfCycles = Integer.parseInt(args[2]);
            case 2:
                int rows       = Integer.parseInt(args[0]);
                int columns    = Integer.parseInt(args[1]);
                grid           = new TwoDimensionalGrid(rows, columns);
                break;
            case 1:
                numberOfCycles = Integer.parseInt(args[0]);
            default:
                break;
        }
        System.out.println(grid.toString());
        for(int ii = 0; ii < numberOfCycles; ++ii)
        {
            System.out.println(grid.evolve().toString());
        }
    }
}

