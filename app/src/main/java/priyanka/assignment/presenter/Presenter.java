package priyanka.assignment.presenter;

import android.content.Context;

import java.util.List;

import priyanka.assignment.data.Route;

/**
 * Created by User on 16-02-2018.
 */

public class Presenter implements GetRouteData.Presenter, GetRouteData.onGetDataListener {
    private GetRouteData.View mGetDataView;
    private Interactor mIntractor;

    public Presenter(GetRouteData.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        mIntractor = new Interactor(this);
    }

    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context, url);
    }

    @Override
    public void onSuccess(String message, List<Route> routesdata) {
        mGetDataView.onGetDataSuccess(message, routesdata);
    }

    @Override
    public void onFailure(String message) {

        mGetDataView.onGetDataFailure(message);
    }
}
