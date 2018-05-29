package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich;

        try {

            JSONObject jsonObject = new JSONObject(json);

            JSONObject nameObject = jsonObject.getJSONObject("name");
            String mainName = nameObject.getString("mainName");
            JSONArray alsoKnownAsJson = nameObject.getJSONArray("alsoKnownAs");

            ArrayList<String> alsoKnownAsList = new ArrayList<>();

            for (int i = 0; i < alsoKnownAsJson.length(); i++)
                alsoKnownAsList.add(alsoKnownAsJson.getString(i));

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredientsJson = jsonObject.getJSONArray("ingredients");

            ArrayList<String> ingredientsList = new ArrayList<>();

            for (int i = 0; i < ingredientsJson.length(); i++)
                ingredientsList.add(ingredientsJson.getString(i));

            sandwich = new Sandwich(
                    mainName,
                    alsoKnownAsList,
                    placeOfOrigin,
                    description,
                    image,
                    ingredientsList
            );

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return sandwich;
    }
}
