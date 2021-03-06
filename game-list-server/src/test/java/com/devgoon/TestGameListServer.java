package com.devgoon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devgoon.games.Game;

import org.junit.Test;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Integration Test
 */
public class TestGameListServer
{
    /**
     * Get all the TurboGrafx Games
     */
    @Test
    public void testTurboGrafxGamesAll()
    {
        final String url = "http://localhost:8080/turbografx/games";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Game>> response = restTemplate
                                              .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Game>>(){});
        List<Game> games = response.getBody();

        Assert.notEmpty(games, "Should not be empty.");

       games.stream().forEach(System.out::println);

    }
    /**
     * Find the TurboGrafx game by title
     */
    @Test
    public void testTurboGrafxGamesFindByTitle()
    {
        final String url = "http://localhost:8080/turbografx/games/{title}";

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("title", "Bonk");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Game>> response = restTemplate
            .exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Game>>(){});

        List<Game> games = response.getBody();

        Assert.notEmpty(games, "Should not be empty.");

        Assert.isTrue(games.get(0).getName().equals("Bonk 3: Bonk’s Big Adventure"),"First title should be Bonk 3: Bonk’s Big Adventure.");

        Assert.isTrue(games.get(games.size()-1).getName().equals("Bonk’s Revenge"),"Last title should be Bonk’s Revenge.");

    }
    /**
     * Find the turboGrafx games by genre
     */
    @Test
    public void testTurboGrafxGamesFindByGenre()
    {
        final String url = "http://localhost:8080/turbografx/games/genre/{genre}";

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("genre", "RPG");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Game>> response = restTemplate
            .exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Game>>(){});

        List<Game> games = response.getBody();

        Assert.notEmpty(games, "Should not be empty.");

        Assert.isTrue(games.get(0).getName().equals("Double Dungeons"),"First title should be Double Dungeons.");

    }

}

