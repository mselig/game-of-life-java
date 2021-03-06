package com.gol.base;


/**
 *  implements an interface for grids in Conway's Game of Life
 */
public interface Grid
{
    /**
     *  provides the evolved grid
     *
     *  @return this
     *      itself
     */
    public Grid evolve();


    /**
     *  provides the number of evolution cycles already lived through
     *
     *  @return numberOfCycles
     *      integer number of evolution cycles
     */
    public int getEvolutionCycle();


    /**
     *  Boolean check of the two grids are identical in size and state of all cells
     *
     *  @param object
     *      some object to check against equality
     *
     *  @return isEqual
     *      Boolean indicating whether there is equality or not
     */
    @Override
    public boolean equals(Object object);


    /**
     *  provides the grids's complete state
     *
     *  @return asString
     *      String indicating the grid's complete state
     */
    @Override
    public String toString();

}

