package priyanka.assignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import priyanka.assignment.activity.RoutesListActivity;
import priyanka.assignment.data.Route;
import priyanka.assignment.walmart.com.routeapp.R;

/**
 * Created by User on 15-02-2018.
 */

public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.MyViewHolder> {

    List<Route> routeList;
    Context context;

    public RouteListAdapter(List<Route> routeList, Context context) {
        this.context = context;
        this.routeList = routeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_list_row, parent, false);
        itemView.setOnClickListener(RoutesListActivity.myOnClickListener);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Route route = routeList.get(position);
        holder.routeName.setText(route.getName());
        Picasso.with(context).load(route.getImage()).into(holder.routeImage);
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView routeName;
        public ImageView routeImage;

        public MyViewHolder(View view) {
            super(view);
            routeName = (TextView) view.findViewById(R.id.textView);
            routeImage = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
