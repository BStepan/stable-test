package com.sqisland.tutorial.recipes.ui.recipe;

import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.test.RecipeRobot;

import org.junit.Rule;
import org.junit.Test;



public class RecipeActivityTest {

    private static final String CARROTS_ID = "creamed_carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule =
            new ActivityTestRule<>(RecipeActivity.class, true, false);

    @Test
    public void recipeNotFound(){
        new RecipeRobot()
                .launch(activityRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }

    @Test
    public void favoriteSet() {
        new RecipeRobot()
                .launch(activityRule,CARROTS_ID)
                .title("Creamed Carrots")
                .isNotFavorite()
                .titleClick()
                .isFavorite();
    }

    @Test
    public void alreadyFavorite() {
        new RecipeRobot()
                .setFavorite(CARROTS_ID)
                .launch(activityRule, CARROTS_ID)
                .isFavorite();

    }



}