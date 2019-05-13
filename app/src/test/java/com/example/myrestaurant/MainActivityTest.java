package com.example.myrestaurant;


import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class) //enables our code o be run on JVM instaed of the device

public class MainActivityTest {

    //configure so that this class knows which class is being tested
    private MainActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent(){
        TextView RestaurantsTextView = activity.findViewById(R.id.myRestaurantsTextView);
        assertTrue("MyRestaurants".equals(RestaurantsTextView.getText().toString()));
    }


































































































































}