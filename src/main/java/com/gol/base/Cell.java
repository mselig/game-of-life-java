package com.gol.base;


public class Cell extends PrimitiveCell
{
    private int numberOfLivingNeighbours;

    /**
     *
     *  @param isAlive
     */
    public Cell(boolean isAlive)
    {
        super(isAlive);
    }


    /**
     *
     */
    public Cell()
    {
        super();
    }


    /**
    *
    */
    public Cell(int isAlive)
    {
        super(isAlive);
    }


    /**
     *
     * @param neighbours
     */
    public Cell refresh(Cell[] neighbours) throws IllegalArgumentException
    {
        if(neighbours == null)
        {
            throw new IllegalArgumentException("'neighbours' is null");
        }
        int counterOfLivingNeighbours = 0;
        for(Cell neighbour : neighbours)
        {
            if(neighbour.isAlive())
            {
                ++counterOfLivingNeighbours;
            }
        }
        setNumberOfLivingNeighbours(counterOfLivingNeighbours);
        return this;
    }


    /**
     *
     */
    public Cell evolve()
    {
        evolve(numberOfLivingNeighbours);
        return this;
    }



    public int getNumberOfLivingNeighbours()
    {
        return numberOfLivingNeighbours;
    }


    private void setNumberOfLivingNeighbours(int numberOfLivingNeighbours)
    {
        this.numberOfLivingNeighbours = numberOfLivingNeighbours;
    }

}

