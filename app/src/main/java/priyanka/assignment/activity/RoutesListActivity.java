package priyanka.assignment.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import priyanka.assignment.adapter.RouteListAdapter;
import priyanka.assignment.data.Route;
import priyanka.assignment.presenter.GetRouteData;
import priyanka.assignment.presenter.Presenter;
import priyanka.assignment.walmart.com.routeapp.R;

/**
 * Created by User on 16-02-2018.
 */

public class RoutesListActivity extends Activity implements GetRouteData.View {
    public static RecyclerView recyclerView;
    public static View.OnClickListener myOnClickListener;
    private static List<Route> routsList = new ArrayList<>();
    private Presenter mPresenter;
    private RouteListAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);
        mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        initViews();
    }

    private void initViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        myOnClickListener = new MyOnClickListener(this);

    }


    public void onGetDataSuccess(String message, List<Route> routesdata) {
        Log.d("responsedata", "jjjkkj");
        rAdapter = new RouteListAdapter(routesdata, getApplicationContext());
        Log.d("responsedata", "" + routesdata);
        this.routsList = routesdata;
        recyclerView.setAdapter(rAdapter);


    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status", message);
    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

            Log.d("onclick", "inside onclick");
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView routeNameView
                    = (TextView) viewHolder.itemView.findViewById(R.id.textView);
            String selectedName = (String) routeNameView.getText();
            Route selectedRoute = null;
            for (Route route : routsList) {
                if (route.getName().equals(selectedName)) {
                    selectedRoute = route;
                    break;
                }
            }
            Intent intent = new Intent(context, RouteListDetailActivity.class);
            intent.putExtra("SelectedRoute", selectedName);
            intent.putExtra("Routes", selectedRoute);
            context.startActivity(intent);
        }
    }
}
