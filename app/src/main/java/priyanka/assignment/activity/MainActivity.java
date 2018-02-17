package priyanka.assignment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import priyanka.assignment.walmart.com.routeapp.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findRoutes(View view) {
        Intent intent = new Intent(this, RoutesListActivity.class);
        startActivity(intent);
    }
}
