package priyanka.assignment.presenter;

import android.content.Context;

import java.util.List;

import priyanka.assignment.data.Route;

/**
 * Created by User on 16-02-2018.
 */

public interface GetRouteData {
    interface View {
        void onGetDataSuccess(String message, List<Route> list);

        void onGetDataFailure(String message);
    }

    interface Presenter {
        void getDataFromURL(Context context, String url);
    }

    interface Interactor {
        void initRetrofitCall(Context context, String url);

    }

    interface onGetDataListener {
        void onSuccess(String message, List<Route> list);

        void onFailure(String message);
    }

}
