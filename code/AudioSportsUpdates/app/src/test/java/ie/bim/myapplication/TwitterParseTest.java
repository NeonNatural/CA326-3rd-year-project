package ie.bim.myapplication;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


import org.junit.Test;

import ie.bim.myapplication.data.model.Tweet;

import static org.junit.Assert.*;

public class TwitterParseTest {

    @Test
    public void tweet_json_isValid() {
        String json = "{ \"id\": 1, \"text\": \"test text\" }";

        Gson gson = new Gson();

        Tweet tweet = gson.fromJson(json, Tweet.class);

        assertNotNull(tweet);
    }

    @Test(expected = JsonSyntaxException.class)
    public void tweet_json_notValid() {
        String json = "\"id\": 1, \"text\": \"test text\" }";

        Gson gson = new Gson();

        gson.fromJson(json, Tweet.class);
    }

}
