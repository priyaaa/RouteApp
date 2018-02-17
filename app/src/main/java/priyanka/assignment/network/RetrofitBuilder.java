package priyanka.assignment.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 15-02-2018.
 */

public class RetrofitBuilder {

    public static final String BASE_URL = "http://www.mocky.io/";
    private static Retrofit retrofit = null;

    public static Retrofit getInstancce(Context ctx) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
