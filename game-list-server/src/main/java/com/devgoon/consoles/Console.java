

package com.devgoon.consoles;

import java.util.List;

import com.devgoon.games.Game;


/**
 * Console interface
 *
 */
public interface Console
{
    /**
     * Get the console name
     * @return
     */
    String getConsoleName();

    /**
     * Get the games for a given console
     * @return
     */
    List<Game> getGames();
}

