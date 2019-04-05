/*
 * Copyright (c) 2019 Thermo Fisher Scientific
 * All rights reserved.
 */


package com.devgoon.games;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.devgoon.consoles.ConsoleType;


/**
 * TODO: Class description
 */
public class GamesUtil
{
    /**
     * TODO: Method description
     * @param consoleType
     * @return
     * @throws IOException
     */
    public List<Game> loadGames(ConsoleType consoleType) throws IOException
    {
        List<Game> result = new ArrayList<>();

        InputStream stream = getClass()
                             .getResourceAsStream(consoleType.getGameList()) != null ? getClass()
                             .getResourceAsStream(consoleType.getGameList()) : getClass().getClassLoader().getResourceAsStream(consoleType.getGameList());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream)))
        {
            String game;
            while ((game = reader.readLine()) != null)
            {
                String name = game.split(",")[0].trim();
                String genre = game.split(",")[game.split(",").length-1].toUpperCase().trim();

                result.add(makeGame(name, genre));
            }
        }

        return result;
    }

    private static Game makeGame(String name, String genre)
    {
        return new Game(name, genre);
    }
}

