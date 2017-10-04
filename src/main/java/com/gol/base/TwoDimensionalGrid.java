package com.gol.base;


/**
 *  implements a two-dimensional grid of cells in Conway's Game of Life
 */
public class TwoDimensionalGrid implements Grid
{
    private final int rows;
    private final int columns;

    private int cycle = 0;
    private Cell[][] grid;


    /**
     *  constructor by size parameters
     *
     *  @param numberOfRows
     *      integer number of rows
     *  @param numberOfColumns
     *      integer number of columns
     *
     *  @throws IllegalArgumentException
     *      in case of encountering non-positive integers
     */
    public TwoDimensionalGrid(int numberOfRows, int numberOfColumns) throws IllegalArgumentException
    {
        if(numberOfRows < 1)
        {
            throw new IllegalArgumentException("non-positive 'numberOfRows': " + numberOfRows);
        }
        if(numberOfColumns < 1)
        {
            throw new IllegalArgumentException("non-positive 'numberOfColumns': " + numberOfColumns);
        }
        this.rows = numberOfRows;
        this.columns = numberOfColumns;

        this.grid = new Cell[rows][columns];
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                grid[row][col] = new Cell();
            }
        }
    }


    /**
     *  constructor by integer array
     *
     *  @param cells
     *      array of array of integers indicating the cells' live states
     */
    public TwoDimensionalGrid(int[][] cells)
    {
        if(cells == null)
        {
            throw new IllegalArgumentException("'cells' is null");
        }
        if(cells.length < 1)
        {
            throw new IllegalArgumentException("zero rows");
        }
        this.rows = cells.length;
        if(cells[0].length < 1)
        {
            throw new IllegalArgumentException("zero columns");
        }
        this.columns = cells[0].length;

        this.grid = new Cell[rows][columns];
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                grid[row][col] = new Cell(cells[row][col]);
            }
        }
    }


    /**
     *  @see com.gol.base.Grid#evolve()
     */
    @Override
    public TwoDimensionalGrid evolve()
    {
        refreshCells();
        evolveCells();
        return this;
    }


    /**
     *  invokes a refresh for each cell
     */
    private void refreshCells()
    {
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                grid[row][col].refresh(getNeighbours(row, col));
            }
        }
    }


    /**
     *  provides the neighbouring cells of a certain cell in the grid
     *
     *  @param row
     *      integer row of the cell
     *  @param col
     *      integer column of the cell
     *
     *  @return neighbours
     *      array of neighbouring cells
     */
    private Cell[] getNeighbours(int row, int col)
    {
        Cell[] neighbours = new Cell[8];
        neighbours[0] = getCell(row - 1, col - 1);
        neighbours[1] = getCell(row - 1, col    );
        neighbours[2] = getCell(row - 1, col + 1);
        neighbours[3] = getCell(row    , col - 1);
        neighbours[4] = getCell(row    , col + 1);
        neighbours[5] = getCell(row + 1, col - 1);
        neighbours[6] = getCell(row + 1, col    );
        neighbours[7] = getCell(row + 1, col + 1);
        return neighbours;
    }


    /**
     *  invokes an evolution for each cell
     */
    private void evolveCells()
    {
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                grid[row][col].evolve();
            }
        }
        ++cycle;
    }


    /**
     *  @see com.gol.base.Grid#equals(Object)
     */
    @Override
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        if(!TwoDimensionalGrid.class.isAssignableFrom(object.getClass()))
        {
            return false;
        }
        final TwoDimensionalGrid other = (TwoDimensionalGrid) object;
        if((other.getNumberOfRows() != getNumberOfRows()) || (other.getNumberOfColumns() != getNumberOfColumns()))
        {
            return false;
        }
        for(int row = 0; row < rows; ++row)
        {
            for(int col = 0; col < columns; ++col)
            {
                if(other.getCell(row, col).isAlive() != getCell(row, col).isAlive())
                {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     *  @see com.gol.base.Grid#toString()
     */
    @Override
    public String toString()
    {
        String output = "--------------------------------------------------------------------------------\n";
        output += String.format("evolution cycle: %03d", cycle);
        for(int row = 0; row < rows; ++row)
        {
            output += "\n";
            for(int col = 0; col < columns; ++col)
            {
                output += grid[row][col].toString();
            }
        }
        return output;
    }


    /**
     *  provides a certain cell in the grid
     *
     *  @param row
     *      integer row of the cell
     *  @param col
     *      integer column of the cell
     *
     *  @return cell
     *      the cell in the specified row and column
     */
    private Cell getCell(int row, int col)
    {
        row = wrapIndex(row, rows);
        col = wrapIndex(col, columns);
        return grid[row][col];
    }


    /**
     *  wraps an index into the interval [0, limit[
     *
     *  @param index
     *      integer index to be wrapped
     *  @param limit
     *      integer boundary limit
     *
     *  @return wrappedIndex
     *      wrapped integer index
     */
    private int wrapIndex(int index, int limit)
    {
        if(index < 0)
        {
            index += limit;
        }
        if(index >= limit)
        {
            index = index % limit; // periodic boundary conditions
        }
        return index;
    }


    /**
     *  provides the number of rows of the grid
     *
     *  @return numberOfRows
     *      integer number of rows
     */
    public int getNumberOfRows()
    {
        return rows;
    }


    /**
     *  provides the number of columns of the grid
     *
     *  @return numberOfColumns
     *      integer number of columns
     */
    public int getNumberOfColumns()
    {
        return columns;
    }


    /**
     *  @see com.gol.base.Grid#getEvolutionCycle()
     */
    @Override
    public int getEvolutionCycle()
    {
        return cycle;
    }

}

