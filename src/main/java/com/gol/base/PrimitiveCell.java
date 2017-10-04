package com.gol.base;


public class PrimitiveCell
{
    private boolean isAlive;


    /**
     *
     *  @param isAlive
     */
    public PrimitiveCell(boolean isAlive)
    {
        this.isAlive = isAlive;
    }


    /**
     *
     */
    public PrimitiveCell()
    {
        this(Math.random() < 0.5);
    }


    /**
     *
     */
    public PrimitiveCell(int isAlive)
    {
        this(isAlive != 0);
    }


    /**
     *
     *
     *  1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     *  2. Any live cell with two or three live neighbours lives on to the next generation.
     *  3. Any live cell with more than three live neighbours dies, as if by overpopulation.
     *  4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     *
     *  @param numberOfLivingNeighbours
     */
    protected PrimitiveCell evolve(int numberOfLivingNeighbours)
    {
        if(isAlive)
        {
            if((numberOfLivingNeighbours < 2) | (numberOfLivingNeighbours > 3))
            {
                isAlive = false;
            }
        }
        else if(numberOfLivingNeighbours == 3)
        {
            isAlive = true;
        }
        return this;
    }


    /**
     *
     *  @return isAlive
     */
    public boolean isAlive()
    {
        return isAlive;
    }


    /**
     *
     *  @return asString
     */
    @Override
    public String toString()
    {
        if(isAlive)
        {
            return "[]";
        }
        else
        {
            return "  ";
        }
    }
}

