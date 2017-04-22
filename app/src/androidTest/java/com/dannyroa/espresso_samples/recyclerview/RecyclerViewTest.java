package com.dannyroa.espresso_samples.recyclerview;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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

        RecyclerViewInteraction.<Team>onRecyclerView(withId(R.id.rvTeam)).withItems(getActivity().getTeams()).check(
                new RecyclerViewInteraction.ItemViewAssertion<Team>() {
                    @Override
                    public void check(Team item, View view, NoMatchingViewException e) {
                        matches(hasDescendant(withText(item.getName()))).check(view,e);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        Log.d("Chocolate", "Matched: "+item.getName());
                    }
                }
        );

    }

    public void testMyTest2() throws InterruptedException {

        Thread.sleep(3000);
        int len = getActivity().getTeams().size();
        int len2 = getActivity().getTeams2().size();
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len2; i++) {
                onView(allOf(withId(R.id.rvSubteam), withParent(withRecyclerView(R.id.rvTeam).atPosition(j))))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, scrollTo()));
               /* onView(withId(R.id.rvChapterList))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, scrollTo()));*/
                Thread.sleep(1000);
            /*    onView(withId(R.id.rvChapterList))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));*/
                onView(allOf(withId(R.id.rvSubteam), withParent(withRecyclerView(R.id.rvTeam).atPosition(j))))
                        .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
                pressBack();
            }
            Thread.sleep(1000);
        }
    }

    private static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
