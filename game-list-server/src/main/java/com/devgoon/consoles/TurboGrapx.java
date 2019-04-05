/*
 * Copyright (c) 2019 Thermo Fisher Scientific
 * All rights reserved.
 */


package com.devgoon.consoles;

import com.devgoon.games.Game;
import com.devgoon.games.GamesUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO: Class description
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
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}

