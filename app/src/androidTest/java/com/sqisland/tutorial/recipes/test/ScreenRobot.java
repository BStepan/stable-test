package com.sqisland.tutorial.recipes.test;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

public abstract class ScreenRobot<T extends ScreenRobot>{
    public T checkIsHidden(@IdRes int... viewIds) {
        for (int viewId : viewIds)
        {
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())));
        }
        return (T) this;
    }

    public T checkViewHasText(@IdRes int viewId, @StringRes int stringID){
        onView(withId(viewId))
                .check(matches(withText(stringID)));
        return (T) this;
    }

    public T checkIsSelected(@IdRes int... viewIds) {
        for (int viewId : viewIds)
        {
            onView(withId(viewId))
                    .check(matches(isSelected()));
        }
        return (T) this;
    }

    public T checkIsNotSelected(@IdRes int... viewIds) {
        for (int viewId : viewIds)
        {
            onView(withId(viewId))
                    .check(matches(not(isSelected())));
        }
        return (T) this;
    }

    public T checkViewHasText(@IdRes int viewId, String string) {
        onView(withId(viewId))
                .check(matches(withText(string)));
        return (T) this;
    }

    public T performClick(@IdRes int viewId) {
        onView(withId(viewId))
                .perform(click());
        return (T) this;
    }
}
