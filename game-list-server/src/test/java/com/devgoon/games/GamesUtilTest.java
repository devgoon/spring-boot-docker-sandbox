

package com.devgoon.games;

import java.io.IOException;

import java.net.URISyntaxException;
import java.util.List;

import com.devgoon.consoles.ConsoleType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Tests GamesUtilTest Class
 */
public class GamesUtilTest
{
    /**
     * Tests GamesUtilTest Class
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void loadGames() throws IOException, URISyntaxException
    {
        GamesUtil gamesUtil = new GamesUtil();
        List<Game> result = gamesUtil.loadGames(ConsoleType.TURBOGRAFX);

        result.stream().forEach(System.out::println);
        assertTrue (result.size()>0);
    }
}

