

package com.devgoon;

import java.util.List;
import java.util.stream.Collectors;

import com.devgoon.consoles.ConsoleFactory;
import com.devgoon.consoles.ConsoleType;
import com.devgoon.games.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Main SpringBoot application
 */
@SpringBootApplication
@EnableCaching
@RestController
public class Application
{
    @Autowired
    private GameListService gameListService;

    /**
     * Get all the games
     *
     * @return
     */
    @RequestMapping("/turbografx/games")
    public List<Game> getall()
    {
        return gameListService.getAll(ConsoleType.TURBOGRAFX);
    }

    /**
     * Get all the games that contain the title
     *
     * @param title
     * @return
     */
    @RequestMapping("/turbografx/games/{title}")
    public List<Game> findByTitle(@PathVariable String title)
    {
        return gameListService.findByTitle(ConsoleType.TURBOGRAFX, title);
    }

    /**
     * Get all the games that are of a given genre
     *
     * @param genre
     * @return
     */
    @RequestMapping("/turbografx/games/genre/{genre}")
    public List<Game> findByGenre(@PathVariable String genre)
    {
        return gameListService.findByGenre(ConsoleType.TURBOGRAFX, genre);
    }

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Game List Service implementation
     */
    @Component
    public class GameListService
    {
        /**
         * Find by title
         * @param consoleType
         * @param title
         * @return
         */
        @Cacheable("games")
        public List<Game> findByTitle(ConsoleType consoleType, String title)
        {
            return new ConsoleFactory().getConsole(consoleType).getGames().stream().filter(game -> game.getName().contains(title)).collect(Collectors.toList());

        }

        /**
         * Find game by Console Type and genre
         * @param consoleType
         * @param genre
         * @return
         */
        @Cacheable("games")
        public List<Game> findByGenre(ConsoleType consoleType, String genre)
        {
            return new ConsoleFactory().getConsole(consoleType).getGames().stream().filter(game -> game.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());

        }

        /**
         * Get all the games by ConsoleType
         * @param consoleType
         * @return
         */
        @Cacheable("games")
        public List<Game> getAll(ConsoleType consoleType)
        {
            return new ConsoleFactory().getConsole(consoleType).getGames();
        }

    }
}

