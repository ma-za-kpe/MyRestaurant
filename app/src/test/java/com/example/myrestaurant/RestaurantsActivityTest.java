package com.example.myrestaurant;

import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

//@RunWith(RobolectricGradleTestRunner.class)
//
//public class RestaurantsActivityTest {
//    private RestaurantActivity activity;
//    private ListView mRestaurantListView;
//
//    @Before
//    public void setup() {
//        activity = Robolectric.setupActivity(RestaurantActivity.class);
//        mRestaurantListView = (ListView) activity.findViewById(R.id.listView);
//    }
//
//    @Test
//    public void restaurantListViewPopulates() {
//        assertNotNull(mRestaurantListView.getAdapter());
//        assertEquals(mRestaurantListView.getAdapter().getCount(), 15);
//    }
//}