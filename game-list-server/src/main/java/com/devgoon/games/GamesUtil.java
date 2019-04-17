

package com.devgoon.games;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.URISyntaxException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.devgoon.consoles.ConsoleType;


/**
 * Utility that loads games from a file
 */
public class GamesUtil
{
    /**
     * Load games given a console type
     *
     * @param consoleType
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public List<Game> loadGames(ConsoleType consoleType) throws IOException, URISyntaxException
    {
        List<Game> result = new ArrayList<>();

        try (InputStream stream = getClass().getResourceAsStream(consoleType.getGameList()) != null ? getClass()
                                  .getResourceAsStream(consoleType.getGameList()) : getClass().getClassLoader().getResourceAsStream(consoleType.getGameList()))
        {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream)))
            {
                String game;
                while ((game = reader.readLine()) != null)
                {
                    String name = game.split(",")[0].trim();
                    String genre = game.split(",")[1].toUpperCase().trim();
                    String sRom = game.split(",")[2].trim();
                    byte[] rom = getRom(consoleType, sRom);

                    result.add(makeGame(name, genre, rom));
                }
            }
        }

        return result;
    }

    private static Game makeGame(String name, String genre, byte[] rom)
    {
        return new Game(name, genre, rom);
    }

    private byte[] getRom(ConsoleType consoleType, String romName)
    {
        byte[] result = new byte[0];

        try
        {
            result = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(consoleType.getRomsDirectory() + "/" + romName).toURI()));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }
}

