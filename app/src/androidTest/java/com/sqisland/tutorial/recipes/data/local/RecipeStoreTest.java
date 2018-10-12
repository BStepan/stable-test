package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.sqisland.tutorial.recipes.data.model.Recipe;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RecipeStoreTest {

    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());
    }

    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding", recipe.id);
        assertEquals("Chocolate Pudding", recipe.title);
        assertEquals("2 tablespoons chocolate\n" +
                "yolks of 4 eggs\n" +
                "1 cup sugar\n" +
                "1 quart milk\n" +
                "1 whole egg\n" +
                "2 tablespoons corn starch\n" +
                "\n" +
                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.", recipe.description);


    }

}