package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    // 3- create a arraylist for store the data
    ArrayList<ProductModel> product = new ArrayList<>();



    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // attached the recycler view id give into the main activity
        recyclerView = findViewById(R.id.rvProduct);

        // then set the layout you want to show into recycler view
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));


        // Create productModel instances with random data and different drawables
        product.add(new ProductModel(R.drawable.e , "Product 1" , "Rs 800", "Rs 300", 4.4F));
        product.add(new ProductModel(R.drawable.e , "Product 2" , "Rs 600", "Rs 250", 4.0F));
        product.add(new ProductModel(R.drawable.e , "Product 3" , "Rs 900", "Rs 400", 4.8F));
        product.add(new ProductModel(R.drawable.e , "Product 4" , "Rs 700", "Rs 350", 4.2F));
        product.add(new ProductModel(R.drawable.e , "Product 5" , "Rs 1000", "Rs 500", 4.5F));
        product.add(new ProductModel(R.drawable.e , "Product 6" , "Rs 1200", "Rs 600", 4.6F));
        product.add(new ProductModel(R.drawable.e , "Product 7" , "Rs 500", "Rs 200", 3.9F));
        product.add(new ProductModel(R.drawable.e , "Product 8" , "Rs 1100", "Rs 450", 4.7F));
        product.add(new ProductModel(R.drawable.e , "Product 9" , "Rs 850", "Rs 320", 4.3F));
        product.add(new ProductModel(R.drawable.e , "Product 10", "Rs 950", "Rs 380", 4.1F));

        RecyclerProductAdaptor recyclerProductAdaptor = new RecyclerProductAdaptor(getApplicationContext(), product);
        recyclerView.setAdapter(recyclerProductAdaptor);

    }
}