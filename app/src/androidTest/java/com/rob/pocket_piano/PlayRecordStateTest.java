package com.rob.pocket_piano;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PlayRecordStateTest
{

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void playRecordStateTest()
    {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.Btn_Record), withContentDescription("Record"),
                        withParent(withId(R.id.LinearLayout_RecordPlaybackButtons)),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.Lbl_State), withText("Recording"),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout_RecordPlaybackButtons),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Recording")));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.Btn_Stop), withContentDescription("Stop"),
                        withParent(withId(R.id.LinearLayout_RecordPlaybackButtons)),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.Lbl_State), withText("Ready"),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout_RecordPlaybackButtons),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                2),
                        isDisplayed()));
        textView2.check(matches(withText("Ready")));

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.Btn_Play), withContentDescription("Play"),
                        withParent(withId(R.id.LinearLayout_RecordPlaybackButtons)),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.Lbl_State), withText("Playing"),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout_RecordPlaybackButtons),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Playing")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position)
    {

        return new TypeSafeMatcher<View>()
        {
            @Override
            public void describeTo(Description description)
            {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view)
            {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
