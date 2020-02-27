package com.udacity.gradle.builditbigger.backend;

import com.example.javajoker.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** Endpoint method that fetches a joke from the JavaJoker library*/
    @ApiMethod(name = "fetchJoke")
    public MyJoke fetchJoke() {
        MyJoke fetchedJoke = new MyJoke();
        JokeProvider jokeProvider = new JokeProvider();
        fetchedJoke.setData(jokeProvider.getJoke());

        return fetchedJoke;
    }

}
