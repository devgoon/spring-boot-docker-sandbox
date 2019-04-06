

package com.devgoon.consoles;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.devgoon.games.Game;
import com.devgoon.games.GamesUtil;


/**
 * Nintendo implementation of the Console interface
 */
public class NES implements Console
{
    private static final String CONSOLE_NAME = ConsoleType.NES.getConsoleName();

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
            result = new GamesUtil().loadGames(ConsoleType.NES);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}

