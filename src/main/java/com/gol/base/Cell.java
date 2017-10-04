package com.gol.base;


/**
 *  implements a cell, which is aware of its live neighbours, in Convey's Game of Life
 */
public class Cell extends PrimitiveCell
{
    private int numberOfLivingNeighbours;

    /**
     *  @see com.gol.base.PrimitiveCell#PrimitiveCell(boolean)
     */
    public Cell(boolean isAlive)
    {
        super(isAlive);
    }


    /**
     *  @see com.gol.base.PrimitiveCell#PrimitiveCell()
     */
    public Cell()
    {
        super();
    }


    /**
     *  @see com.gol.base.PrimitiveCell#PrimitiveCell(int)
     */
    public Cell(int isAlive)
    {
        super(isAlive);
    }


    /**
     *  refreshes the number of neighbours that are alive
     *
     *  @param neighbours
     *      array of neighbouring cells
     *
     *  @return this
     *      itself
     *
     *  @throws IllegalArgumentException
     *      in case of encountering null as input
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
     *  invokes an evolution
     *
     *  @return this
     *      itself
     */
    public Cell evolve()
    {
        evolve(numberOfLivingNeighbours);
        return this;
    }


    /**
     *  provides the number of neighbours that are alive
     *
     *  @return numberOfLivingNeighbours
     *      integer number of living neighbours
     */
    public int getNumberOfLivingNeighbours()
    {
        return numberOfLivingNeighbours;
    }


    /**
     *  sets the number of neighbours that are alive
     *
     *  @param numberOfLivingNeighbours
     *      integer number of living neighbours
     */
    private void setNumberOfLivingNeighbours(int numberOfLivingNeighbours)
    {
        this.numberOfLivingNeighbours = numberOfLivingNeighbours;
    }

}

