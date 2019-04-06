

package com.devgoon.consoles;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.devgoon.games.Game;
import com.devgoon.games.GamesUtil;


/**
 * Sega Master System implementation of the Console interface
 */
public class SegaMasterSystem implements Console
{
    private static final String CONSOLE_NAME = ConsoleType.SEGA.getConsoleName();

    @Override
    public String getConsoleName()
    {
        return CONSOLE_NAME;
    }

    @Override
    public List<Game> getGames()
    {
        List<Game> result = new ArrayList<>();
        try
        {
            result = new GamesUtil().loadGames(ConsoleType.SEGA);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}

