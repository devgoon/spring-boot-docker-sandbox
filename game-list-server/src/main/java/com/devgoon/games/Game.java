
package com.devgoon.games;

/**
 * Represents a game
 */
public class Game
{
    private String name;
    private String genre;

    public Game(){}
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

