package ie.bim.myapplication;

import org.junit.Test;

import ie.bim.myapplication.data.model.Tweet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TweetTest {

    @Test
    public void tweet_isEquals() {
        long id = 1L;
        String text = "test text";

        Tweet a = new Tweet();
        a.id = id;
        a.text = text;

        Tweet b = new Tweet();
        b.id = id;
        b.text = text;

        assertEquals(a, b);
    }

    @Test
    public void tweet_notEquals_byId() {
        long id = 1L;
        String text = "test text";

        Tweet a = new Tweet();
        a.id = id;
        a.text = text;

        Tweet b = new Tweet();
        b.id = 2;
        b.text = text;

        assertNotEquals(a, b);
    }

    @Test
    public void tweet_notEquals_byText() {
        long id = 1L;
        String text = "test text";

        Tweet a = new Tweet();
        a.id = id;
        a.text = text;

        Tweet b = new Tweet();
        b.id = id;
        b.text = "";

        assertNotEquals(a, b);
    }

}
