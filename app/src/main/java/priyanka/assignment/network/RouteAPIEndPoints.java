package priyanka.assignment.network;

import priyanka.assignment.data.Routes;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 15-02-2018.
 */

public interface RouteAPIEndPoints {

    @GET("v2/5808f00d10000005074c6340")
    public Call<Routes> getRoutes();

}
