package com.example.myrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantActivity extends AppCompatActivity {

    public static final String TAG = RestaurantActivity.class.getSimpleName();

    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines); // must match constructor!
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantActivity.this, restaurant, Toast.LENGTH_LONG).show();
                Log.v(TAG, "In the onItemClickListener!");
                Log.d(TAG, "In the onItemClickListener!");
            }

        });


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText(location);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
