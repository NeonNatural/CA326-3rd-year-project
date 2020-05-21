package ie.bim.myapplication.data.model;

import com.google.gson.annotations.SerializedName;

public class BearerToken {

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("access_token")
    public String accessToken;

}
