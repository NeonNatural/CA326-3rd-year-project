package ie.bim.myapplication;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.junit.Test;

import ie.bim.myapplication.data.model.BearerToken;
import static org.junit.Assert.*;


public class BearerTokenParseTest {

    @Test
    public void bearerToken_json_isValid(){
        String bearerJson = "{\"token_type\":\"token\",\"access_token\":\"myaccess\"}";
        Gson gson = new Gson();

        BearerToken bearer = gson.fromJson(bearerJson,BearerToken.class);
        assertNotNull(bearer);
    }

    @Test(expected = JsonParseException.class)
    public void bearerToken_json_not_isValid(){
        String bearerJson = "{{{{{{\"token_type\":\"token\",\"access_token\":\"myaccess\"}";
        Gson gson = new Gson();

        gson.fromJson(bearerJson,BearerToken.class);
    }
}
