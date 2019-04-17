

package com.devgoon.consoles;

/**
 * An enumeration of consoles
 *
 */
public enum ConsoleType
{
    TURBOGRAPX("TURBOGRAPX 16", "roms/tg16/game-list.csv", "roms/tg16"), SEGA("SEGA MASTER SYSTEM", "roms/sega/game-list.csv", "roms/sega:"), NES("NINTENDO", "roms/nes/game-list.csv", "roms/nes");

    private String consoleName;
    private String gameList;
    private String romsDirectory;


    /**
     * Get the game list file name
     * @return
     */
    public String getGameList()
    {
        return gameList;
    }


    /**
     * Get console name
     * @return
     */
    public String getConsoleName()
    {
        return consoleName;
    }

    /**
     * Get rom directory
     * @return
     */
    public String getRomsDirectory()
    {
        return romsDirectory;
    }

    private ConsoleType(String consoleName, String gameList, String romsDirectory)
    {
        this.consoleName = consoleName;
        this.gameList = gameList;
        this.romsDirectory = romsDirectory;
    }
}

