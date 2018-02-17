package priyanka.assignment.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

import priyanka.assignment.data.Route;
import priyanka.assignment.data.Stop;
import priyanka.assignment.walmart.com.routeapp.R;

public class RouteListDetailActivity extends Activity {

    TextView routeName, routedesc;
    ImageView routeImage, acessIconView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list_detail);

        routedesc = (TextView) findViewById(R.id.description);
        routeName = (TextView) findViewById(R.id.routename);
        routeImage = (ImageView) findViewById(R.id.routeimageView);
        acessIconView = (ImageView) findViewById(R.id.accessimageView);
        Intent intent = getIntent();
        String SelectedRoute = (String) intent.getExtras().get("SelectedRoute");
        Route route = (Route) intent.getExtras().getSerializable("Routes");

        routedesc.setText(route.getDescription());
        routeName.setText(route.getName());
        String accessIcon = route.getAccessible();
        String text = "true";
        Log.d("ACCESS", accessIcon);
        if (accessIcon.equals(text)) {
            acessIconView.setVisibility(View.VISIBLE);
            acessIconView.setImageResource(R.drawable.access_new);
        }
        Picasso.with(getApplicationContext()).load(route.getImage()).into(routeImage);
        Log.d("selectedroute", SelectedRoute);
        Log.d("Route", route.getDescription());
        List<Stop> stops = route.getStops();
        Iterator<Stop> iterator = stops.iterator();
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // params.setMargins(121, 140, 0, 0);
        ll.setOrientation(LinearLayout.VERTICAL);

        do {
            Stop stop = iterator.next();

            // Create TextView
            TextView stopName = new TextView(this);
            stopName.setText("   " + stop.getName());

            stopName.setLayoutParams(params);

            stopName.setTypeface(Typeface.DEFAULT_BOLD);
            stopName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.dot, 0, 0, 0);

            ll.addView(stopName);
            Log.d("stop Name : ", stop.getName());

            if (iterator.hasNext()) {

                ImageView image_vertical = new ImageView(this);
                image_vertical.setImageResource(R.drawable.vertical);
                image_vertical.setLayoutParams(params);

                ll.addView(image_vertical);

            }
        } while (iterator.hasNext());
    }
}
