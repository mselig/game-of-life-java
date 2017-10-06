package com.gol;

import com.gol.base.Grid;
import com.gol.base.TwoDimensionalGrid;

public class GameOfLife
{
    private static final int defaultNumberOfCycles = 11;

    private int cycles;
    private Grid grid;


    /**
     *  creates and evolves an example game
     *
     *  @param arguments
     *      array of argument strings; options:<code>[[ numberOfRows, numberOfColumns ] [ numberOfCycles ]]</code>
     *
     *  @throws Exception
     */
    public static void main(String[] arguments) throws Exception
    {
        System.out.println((new GameOfLife(arguments)).evolve());
    }


    /**
     *  example constructor
     */
    public GameOfLife()
    {
        this.cycles = defaultNumberOfCycles;
        this.grid = new TwoDimensionalGrid(TwoDimensionalGrid.ExampleCells);
    }


    /**
     *  argument constructor
     *
     *  @param arguments
     *      array of argument strings; options:<code>[[ numberOfRows, numberOfColumns ] [ numberOfCycles ]]</code>
     *
     *  @throws NumberFormatException
     *      in case any argument string cannot be parsed to integer
     */
    public GameOfLife(String[] arguments) throws NumberFormatException
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


    /**
     *  evolves the game
     *
     *  @return asString
     *      String indicating the grid's complete state
     */
    public String evolve()
    {
        return evolve(cycles);
    }


    /**
     *  evolves the game a certain number of times
     *
     *  @return asString
     *      String indicating the grid's complete state
     */
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

