

package com.devgoon.consoles;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.devgoon.games.Game;
import com.devgoon.games.GamesUtil;


/**
 * Turbograpx implementation of the Console interface
 */
public class TurboGrapx implements Console
{
    private static final String CONSOLE_NAME = ConsoleType.TURBOGRAPX.getConsoleName();

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
            result = new GamesUtil().loadGames(ConsoleType.TURBOGRAPX);
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}

