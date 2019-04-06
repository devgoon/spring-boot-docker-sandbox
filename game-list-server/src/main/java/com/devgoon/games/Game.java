

package com.devgoon.games;

import java.io.Serializable;


/**
 * Represents a game
 */
public class Game implements Serializable
{
    private String name;
    private String genre;

    /**
     * TODO: Constructs ...
     */
    public Game()
    {
    }

    /**
     * Constructor
     *
     * @param name
     * @param genre
     */
    public Game(String name, String genre)
    {
        this.name = name;
        this.genre = genre;
    }


    /**
     * Get the name of the game
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the genre of the game
     * @return
     */
    public String getGenre()
    {
        return genre;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s", this.name, this.genre);
    }
}

