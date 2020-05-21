package ie.bim.myapplication.data;

import java.util.List;

import ie.bim.myapplication.data.model.BearerToken;
import ie.bim.myapplication.data.model.Tweet;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TweetApi {

    String CONTENT_TYPE = "Content-type: application/x-www-form-urlencoded;charset=UTF-8";

    @FormUrlEncoded
    @POST("oauth2/token")
    Single<BearerToken> getToken(@Header("Authorization") String Authorization, @Field("grant_type") String grantType);

    @GET("1.1/statuses/user_timeline.json")
    Single<List<Tweet>> getTweet(@Header("Authorization") String bearerToken, @Query("screen_name") String name);

}
