

package com.devgoon.consoles;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.devgoon.games.Game;
import com.devgoon.games.GamesUtil;


/**
 * TurboGrafx implementation of the Console interface
 */
public class TurboGrafx implements Console
{
    private static final String CONSOLE_NAME = ConsoleType.TURBOGRAFX.getConsoleName();

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
            result = new GamesUtil().loadGames(ConsoleType.TURBOGRAFX);
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}

