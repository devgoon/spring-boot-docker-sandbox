/*
 * Copyright (c) 2019 Thermo Fisher Scientific
 * All rights reserved.
 */


package com.devgoon;

import java.util.ArrayList;
import java.util.List;

import com.devgoon.consoles.ConsoleFactory;
import com.devgoon.consoles.ConsoleType;
import com.devgoon.games.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO: Class description
 */
@SpringBootApplication
@RestController
public class Application
{
    /**
     * TODO: Method description
     * @param event
     */
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event)
    {

    }

    /**
     * TODO: Method description
     *
     * @return
     */
    @RequestMapping("/turbograpx")
    public List<Game> turbograpx()
    {
        return new ConsoleFactory().getConsole(ConsoleType.TURBOGRAPX).getGames();
    }

    /**
     * TODO: Method description
     *
     * @return
     */
    @RequestMapping("/sega")
    public List<Game> sega()
    {
        return new ConsoleFactory().getConsole(ConsoleType.SEGA).getGames();
    }

    /**
     * TODO: Method description
     *
     * @return
     */
    @RequestMapping("/nes")
    public List<Game> nes()
    {
        return new ConsoleFactory().getConsole(ConsoleType.NES).getGames();
    }
    /**
     * TODO: Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }



}

