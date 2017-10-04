package com.gol.base;

/**
 *  implements the absolute minimum of Conway's Game of Life
 */
public class PrimitiveCell
{
    private boolean isAlive;


    /**
     *  Boolean constructor
     *
     *  @param isAlive
     *      Boolean indicating the cell's live state
     */
    public PrimitiveCell(boolean isAlive)
    {
        this.isAlive = isAlive;
    }


    /**
     *  random constructor that dices a live state
     */
    public PrimitiveCell()
    {
        this(Math.random() < 0.5);
    }


    /**
     *  integer constructor that interprets zero, and only zero, as dead
     *
     *  @param isAlive
     *      integer indicating the cell's live state
     */
    public PrimitiveCell(int isAlive)
    {
        this(isAlive != 0);
    }


    /**
     *  evolves the cell's life state according to Conway's rules:<p>
     *  <ul>
     *      <li>1. Any live cell with fewer than two live neighbours dies, as if caused by <i>underpopulation</i>.
     *      <li>2. Any live cell with two or three live neighbours lives on to the next generation.
     *      <li>3. Any live cell with more than three live neighbours dies, as if by <i>overpopulation</i>.
     *      <li>4. Any dead cell with exactly three live neighbours becomes a live cell, as if by <i>reproduction</i>.
     *  </ul>
     *
     *  @param numberOfLivingNeighbours
     *      integer specifying the number of living neighbours
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
     *  provides the cell's live state
     *
     *  @return isAlive
     *      Boolean indicating the cell's live state
     */
    public boolean isAlive()
    {
        return isAlive;
    }


    /**
     *  provides the cell's live state as String
     *
     *  @return asString
     *      String indicating the cell's live state
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

