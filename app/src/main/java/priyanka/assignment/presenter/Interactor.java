package priyanka.assignment.presenter;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import priyanka.assignment.data.Route;
import priyanka.assignment.data.Routes;
import priyanka.assignment.network.RetrofitBuilder;
import priyanka.assignment.network.RouteAPIEndPoints;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 16-02-2018.
 */

public class Interactor implements GetRouteData.Interactor {
    List<Routes> allcountry = new ArrayList<>();
    List<Route> routsList = new ArrayList<>();
    private GetRouteData.onGetDataListener mOnGetDatalistener;

    public Interactor(GetRouteData.onGetDataListener mOnGetDatalistener) {
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        Retrofit retrofit = RetrofitBuilder.getInstancce(context);
        RouteAPIEndPoints routeAPIEndPoints = retrofit.create(RouteAPIEndPoints.class);
        Call<Routes> call = routeAPIEndPoints.getRoutes();
        call.enqueue(new Callback<Routes>() {
            @Override
            public void onResponse(Call<Routes> call, Response<Routes> response) {
                Routes routes = response.body();

                Log.d("response", "" + response.isSuccessful());
                routsList = routes.getRoutes();

                Log.d("response1", "" + routsList);
                mOnGetDatalistener.onSuccess("success", routsList);
            }

            @Override
            public void onFailure(Call<Routes> call, Throwable t) {

                Log.d("Error", t.getMessage());
                mOnGetDatalistener.onFailure("Data not found. Please try after some time.");
            }
        });
    }
}