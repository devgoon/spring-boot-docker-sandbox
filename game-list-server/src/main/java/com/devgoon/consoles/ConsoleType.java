package com.devgoon.consoles;

/**
 * TODO: Enum description
 *
 */
public enum ConsoleType
{
    TURBOGRAPX("TURBOGRAPX 16", "tg16-game-list.csv"), SEGA("SEGA MASTER SYSTEM", "sega-game-list.csv"), NES("NINTENDO", "nes-game-list.csv");

    private String consoleName;
    private String gameList;


    /**
     * TODO: Method description
     * @return
     */
    public String getGameList()
    {
        return gameList;
    }


    /**
     * TODO: Method description
     * @return
     */
    public String getConsoleName()
    {
        return consoleName;
    }

    private ConsoleType(String consoleName, String gameList)
    {
        this.consoleName = consoleName;
        this.gameList = gameList;
    }
}

