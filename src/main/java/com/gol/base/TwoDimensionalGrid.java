package com.gol.base;

public class TwoDimensionalGrid
{
    private final int rows;
    private final int columns;

    private int cycle = 0;
    private Cell[][] grid;


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


    public TwoDimensionalGrid evolve()
    {
        refreshCells();
        evolveCells();
        return this;
    }



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
     *
     *  @return asString
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


    private Cell getCell(int row, int col)
    {
        row = wrapIndex(row, rows);
        col = wrapIndex(col, columns);
        return grid[row][col];
    }


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


    public int getNumberOfRows()
    {
        return rows;
    }


    public int getNumberOfColumns()
    {
        return columns;
    }


    public int getEvolutionCycle()
    {
        return cycle;
    }

}

