package com.example.fooding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    String recipe_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        recipe_name= getIntent().getStringExtra("recipe_name");

        imageView = findViewById(R.id.recipe_image);
        title = findViewById(R.id.recipe_title);
        description = findViewById(R.id.recipe_description);

        String banana_shake= "banana shake";
        if(recipe_name.equals(banana_shake)){
            setTitle(recipe_name);
            title.setText(recipe_name);

            imageView.setImageResource(R.drawable.bananashake);

            description.setText("Ingredients\n" +
                    "250ml semi-skimmed milk\n" +
                    "1scoop vanilla ice cream\n" +
                    "2 bananas, chopped\n" +
                    "50ml double cream, whipped\n" +
                    "pinch cinnamon\n" +
                    "a few dried banana chips\n" +
                    "1 fresh cherry \n" +
                    "\n" +
                    "Method\n" +
                    "STEP 1\n Put the milk, vanilla ice cream and banana into a blender. Whizz everything up until smooth then pour into a tall glass.\n" +
                    "\n" +
                    "STEP 2\n Top with a big spoonful of whipped cream and decorate with a pinch of cinnamon, some banana chips and a cherry. Serve immediately with a colourful straw.");
        }

        else{
            setTitle(recipe_name);
            title.setText(recipe_name);

            imageView.setImageResource(R.drawable.bananacake);

            description.setText("Ingredients\n" +
                    "125g butter\n" +
                    "3/4 cup caster sugar\n" +
                    "1 tsp vanilla essence\n" +
                    "1 egg\n" +
                    "2 bananas mashed ripe\n" +
                    "1 1/2 cups self-raising flour\n" +
                    "1/4 cup milk"  +
                    " \n" +
                    "Method" +
                    "Melt the butter, sugar and vanilla in a medium-sized saucepan."+ "Remove from the heat." +
                    "Add mashed bananas and stir through until just combined." + "Add egg and mix well. Stir in the flour, then pour in the milk and fold in lightly. Bake at 170C for approximately 40 minutes."

            );
        }
    }
}
