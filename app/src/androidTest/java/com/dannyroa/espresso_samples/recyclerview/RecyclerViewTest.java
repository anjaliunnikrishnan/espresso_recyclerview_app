package com.dannyroa.espresso_samples.recyclerview;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by dannyroa on 5/8/15.
 */

public class
RecyclerViewTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public RecyclerViewTest() {
        super(MainActivity.class);
    }

    @Override protected void setUp() throws Exception {

        getActivity();
    }

    public void testMyTest() throws InterruptedException {

        RecyclerViewInteraction.<Team>onRecyclerView(withId(R.id.recycler_view)).withItems(getActivity().getTeams()).check(
                new RecyclerViewInteraction.ItemViewAssertion<Team>() {
                    @Override
                    public void check(Team item, View view, NoMatchingViewException e) {
                        matches(hasDescendant(withText(item.getName()))).check(view,e);
                        Log.d("Check", "Matched: "+item.getName());
                    }
                }
        );
    }

    public void testMyTest2() throws InterruptedException {

        Thread.sleep(3000);
        int len = getActivity().getTeams().size();
        for(int i = 0; i < len ; i++){
            onView(withId(R.id.recycler_view))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
            Thread.sleep(1000);
            pressBack();
        }
        for(int i = 0; i < len ; i++){
            onView(withId(R.id.recycler_view2))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
            Thread.sleep(1000);
            pressBack();
        }
        Thread.sleep(3000);
    }

}
