package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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


        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);

                // 3- attached the layout
                dialog.setContentView(R.layout.dialoglayoutforupdateproduct);


                //Find ids becuase we want to get data from
                TextView tvProductFormName = dialog.findViewById(R.id.tvProductFormName);
                EditText etProductName = dialog.findViewById(R.id.etProductName);
                EditText etProductPrice = dialog.findViewById(R.id.etProductPrice);
                Button btnSubmitProduct = dialog.findViewById(R.id.btnSubmitProduct);


                tvProductFormName.setText("Update Product");
                etProductName.setText(product.get(position).tvProductName);
                etProductPrice.setText(product.get(position).tvProductCurrentPrice);


                btnSubmitProduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "" , price = "";

                        if(!etProductName.getText().toString().equals(""))
                            name = etProductName.getText().toString();
                        else {
                            Toast.makeText(context,
                                    "Please Enter Product Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!etProductPrice.getText().toString().equals(""))
price = etProductPrice.getText().toString();
                        else {
                            Toast.makeText(context,
                                    "Please Enter Product Name", Toast.LENGTH_SHORT).show();
                        }

                        product.set( position, new ProductModel(name, price , product.get(position).ivProductImg));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


      holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context).
                       setTitle("Delete Product").
                     setMessage("Are Your Sure you want to delete ").
                       setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override
                        public void onClick(DialogInterface dialog, int which) {
                              notifyItemRemoved(position);
                          }
                     }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                         @Override
                        public void onClick(DialogInterface dialog, int which) {

                         }
                        });

               builder.show();
             return true;
           }
        });
    }



    @Override
    public int getItemCount() {
        return product.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView tvProductName , tvProductCurrentPrice , tvProductSalePrice;
        ImageView ivProductImg;
        RatingBar rbProductRating;

        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductCurrentPrice = itemView.findViewById(R.id.tvProductCurrentPrice);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductSalePrice = itemView.findViewById(R.id.tvProductSalePrice);
            ivProductImg = itemView.findViewById(R.id.ivProductImg);
            rbProductRating = itemView.findViewById(R.id.rbProductRating);
            llrow = itemView.findViewById(R.id.llrow);
        }


    }
}
