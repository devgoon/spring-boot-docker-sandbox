/*
 * Copyright (c) 2019 Thermo Fisher Scientific
 * All rights reserved.
 */


package com.devgoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

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
    private static List<String> games = new ArrayList<>();


    /**
     * TODO: Method description
     * @param event
     */
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        try
        {
            System.out.println("Event " + event.toString());
            loadGames();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * TODO: Method description
     *
     * @return
     */
    @RequestMapping("/")
    public String home()
    {
        return String.join(" | ", games);
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

    private void loadGames() throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Application.class.getResourceAsStream("/gameList.txt"))))
        {
            String game;
            while ((game = reader.readLine()) != null)
            {
                games.add(game);
            }
        }
    }

}

