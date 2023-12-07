package com.example.dialog;

import android.widget.EditText;
import android.widget.TextView;

public class ProductModel {

    String tvProductName, tvProductSalePrice , tvProductCurrentPrice;
    float rbProductRating;

    int ivProductImg;

    public ProductModel(int ivProductImg, String tvProductName, String tvProductSalePrice, String tvProductCurrentPrice, float rbProductRating) {
        this.ivProductImg = ivProductImg;
        this.tvProductName = tvProductName;
        this.tvProductSalePrice = tvProductSalePrice;
        this.tvProductCurrentPrice = tvProductCurrentPrice;
        this.rbProductRating = rbProductRating;
    }

    public ProductModel(String tvProductName, String tvProductCurrentPrice, int ivProductImg) {
        this.tvProductName = tvProductName;
        this.tvProductCurrentPrice = tvProductCurrentPrice;
        this.ivProductImg = ivProductImg;
    }
}
