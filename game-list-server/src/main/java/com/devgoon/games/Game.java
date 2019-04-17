

package com.devgoon.games;

import java.io.Serializable;


/**
 * Represents a game
 */
public class Game implements Serializable
{
    private String name;
    private String genre;
    private byte[] rom;

    /**
     * Constructs
     */
    private Game()
    {
    }

    /**
     * Constructor
     *
     * @param name
     * @param genre
     * @param rom
     */
    public Game(String name, String genre, byte[] rom)
    {
        this.name = name;
        this.genre = genre;
        this.rom = rom;
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

    /**
     * Get id
     * @return
     */
    public int getId()
    {
        return hashCode();
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s", this.name, this.genre, hashCode());
    }

    @Override
    public int hashCode()
    {
        return Math.abs(this.genre.hashCode() + this.name.hashCode() + this.rom.hashCode());
    }

    /**
     * Get the rom
     * @return
     */
    public byte[] getRom()
    {
        return rom;
    }
}

