package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    private String[] laptopNames;
    private String[] laptopImages;

    public ProductsAdapter(String[] laptopNames, String[] laptopImages) {
        this.laptopNames = laptopNames;
        this.laptopImages = laptopImages;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.griddata.setText(laptopNames[position]);
        holder.image.setImageURI(Uri.parse(laptopImages[position]));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,ProductsDetail.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laptopNames.length;
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView griddata;
        private SimpleDraweeView image;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            griddata = itemView.findViewById(R.id.griddata);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
