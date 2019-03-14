package app.com.mobileassignment.views;

import org.junit.After;
import org.junit.Before;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static org.junit.Assert.*;

import android.app.Activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import app.com.mobileassignment.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTest {

    public static final String STRING_TO_BE_TYPED = "Nevada";
    public static final String HINT_STRING = "Search";
    public static final String EMPTY_STRING = "";


    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void changeText() {

        // Check that the hint text is set.
        onView(withId(R.id.search)).check(matches(withHint(HINT_STRING)));

        // Type text and then press the button.
        onView(withId(R.id.search))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.search)).check(matches(withText(STRING_TO_BE_TYPED)));

        // Clear search textfield
        onView(withId(R.id.search))
                .perform(replaceText(EMPTY_STRING), closeSoftKeyboard());

        // Check that the hint text is restored.
        onView(withId(R.id.search)).check(matches(withHint(HINT_STRING)));
    }
}