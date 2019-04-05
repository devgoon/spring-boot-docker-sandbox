package com.devgoon.consoles;


import com.devgoon.games.Game;

import java.util.List;


/**
 * Console interface
 *
 */
public interface Console
{
    /**
     * TODO: Method description
     * @return
     */
    String getConsoleName();

    /**
     * TODO: Method description
     * @return
     */
    List<Game> getGames();
}

