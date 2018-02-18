package pankaj.githubscore.api;

import pankaj.githubscore.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by myT on 2/17/2018.
 */

public interface Service {

    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
