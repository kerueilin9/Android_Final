package com.example.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mRecipeList = new LinkedList<>();
    private final LinkedList<String> mDescriptionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList.addLast("Fruit Pizza");
        mDescriptionList.addLast("This simple fruit pizza is beautiful and delicious! A soft sugar cookie crust with a cream cheese frosting and topped with sliced fruit.\n");
        mRecipeList.addLast("The Best Soft Chocolate Chip Cookies");
        mDescriptionList.addLast("These are THE BEST soft chocolate chip cookies! No chilling required. Just ultra thick, soft, classic chocolate chip cookies!\n");
        mRecipeList.addLast("Blender Lemon Pie");
        mDescriptionList.addLast("Blender Lemon Pie! Eggs, butter, sugar, and a WHOLE LEMON blended up and poured into a crust. Springy, custardy, simple lemon magic. \n");
        mRecipeList.addLast("Modern Scotcheroos");
        mDescriptionList.addLast("The classic chocolate covered peanut butter rice krispie bars, but with minimal refined sugar thanks to a few modern swaps. It’s a peanut butter meets chocolate situation, so obviously, your people will love you.\n");
        mRecipeList.addLast("Raspberry Crumble Bars");
        mDescriptionList.addLast("These Raspberry Crumble Bars are THE BEST! So soft, buttery, and delicious. My favorite summer dessert.\n");
        mRecipeList.addLast("Mind-Blowing Vegan Chocolate Pie");
        mDescriptionList.addLast("This vegan chocolate pie is a five-ingredient, no-bake miracle. The ultra-thick and creamy chocolate pie filling is made with (wait for it)… tofu, almond butter, almondmilk, and melted chocolate. Easy!\n");
        mRecipeList.addLast("Gooey Caramel Monkey Bread");
        mDescriptionList.addLast("This Gooey Caramel Monkey Bread is LOADED with homemade caramel sauce and made with a pillowy homemade brioche dough. Perfect made-from-scratch, crowd-pleasing recipe that is conveniently low-maintenance. Just how I like it.\n");
        mRecipeList.addLast("Raw Salted Chocolate Snack Bars");
        mDescriptionList.addLast("Salted Chocolate Snack Bars with simple clean ingredients: pecans, oats, dates, cocoa powder, coconut oil, and maple syrup. SO GOOD!\n");
        mRecipeList.addLast("Carrot Cake Coffee Cake");
        mDescriptionList.addLast("Carrot Cake Coffee Cake! A super easy batter loaded with shredded carrots, topped with a thick crumbly cinnamony streusel, and finished with a melty sweet honey butter.\n");
        mRecipeList.addLast("Almond Butter Cups");
        mDescriptionList.addLast("Almond Butter Cups: made with five ingredients and no refined sugar. So creamy, rich, and yummy!\n");
        mRecipeList.addLast("Best Peach Cobbler");
        mDescriptionList.addLast("I have tried so many peach cobbler recipes and this is by far the BEST peach cobbler! Made with fresh peaches, sugar, and a topping that bakes like slightly underbaked cookie dough, with crunchy sugar broiled on top.\n");
        mRecipeList.addLast("Salted Caramel Brownies");
        mDescriptionList.addLast("Salted Caramel Brownies ♡ thick, dense, fudgy brownies stuffed with homemade salted caramel. HEAVEN.\n");

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeList, mDescriptionList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}