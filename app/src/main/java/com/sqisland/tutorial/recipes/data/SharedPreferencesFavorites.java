package com.sqisland.tutorial.recipes.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.sqisland.tutorial.recipes.data.local.Favorites;

public class SharedPreferencesFavorites implements Favorites {
    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
    }

    public boolean get(String id) {
        return pref.getBoolean(id, false);
    }

    public void put(String id, boolean favorite) {
        SharedPreferences.Editor editor = pref.edit();
        if (favorite) {
            editor.putBoolean(id, true);
        } else {
            editor.remove(id);
        }
        editor.apply();
    }

    public boolean toogle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }
}
