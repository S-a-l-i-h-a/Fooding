package com.example.fooding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecipeListViewAdapter extends BaseAdapter {
    private List<RecipeEntity> recipeList;
    private Context context;

    public RecipeListViewAdapter(List<RecipeEntity> recipeList, Context context) {
        this.recipeList = recipeList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recipeList.indexOf(recipeList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_list_view_item, parent,false);
        RecipeEntity recipe = recipeList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView idTextView = convertView.findViewById(R.id.recipe_id);
        TextView veganTextView = convertView.findViewById(R.id.recipe_vegan);

        imageView.setImageResource(R.drawable.banana);
        idTextView.setText(recipe.getId().toString());
        veganTextView.setText(recipe.getVegan());


        return convertView;
    }
}