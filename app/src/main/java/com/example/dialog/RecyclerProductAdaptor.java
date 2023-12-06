package com.example.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerProductAdaptor extends RecyclerView.Adapter<RecyclerProductAdaptor.ViewHolder> {

    Context context;
    ArrayList<ProductModel> product;

    RecyclerProductAdaptor(Context context, ArrayList<ProductModel> product )
    {
        this.context = context;
        this.product = product;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productdesign, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvProductCurrentPrice.setText(product.get(position).tvProductCurrentPrice);
        holder.tvProductSalePrice.setText(product.get(position).tvProductSalePrice);
        holder.ivProductImg.setImageResource(product.get(position).ivProductImg);
        holder.rbProductRating.setRating(product.get(position).rbProductRating);
    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView tvProductName , tvProductCurrentPrice , tvProductSalePrice;
        ImageView ivProductImg;
        RatingBar rbProductRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductCurrentPrice = itemView.findViewById(R.id.tvProductCurrentPrice);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductSalePrice = itemView.findViewById(R.id.tvProductSalePrice);
            ivProductImg = itemView.findViewById(R.id.ivProductImg);
            rbProductRating = itemView.findViewById(R.id.rbProductRating);
        }


    }
}
