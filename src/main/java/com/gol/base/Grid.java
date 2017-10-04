package com.gol.base;


public interface Grid
{
    public Grid evolve();


    public int getEvolutionCycle();


    @Override
    public boolean equals(Object object);


    @Override
    public String toString();

}

