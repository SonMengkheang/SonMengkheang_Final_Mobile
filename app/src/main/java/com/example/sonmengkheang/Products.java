package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Products extends AppCompatActivity {
    private RecyclerView productlist;
    String[] laptopNames = {"Acer", "Asus", "Dell", "Lenovo", "Vaio"};
    String[] laptopImages = {"https://rupp-ite.s3.ap-southeast-1.amazonaws.com/acer.jpg", "https://rupp-ite.s3.ap-southeast-1.amazonaws.com/asus.jpg",
            "https://rupp-ite.s3.ap-southeast-1.amazonaws.com/dell.jpg", "https://rupp-ite.s3.ap-southeast-1.amazonaws.com/lenovo.jpg", "https://rupp-ite.s3.ap-southeast-1.amazonaws.com/vaio.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        findViewById(R.id.guest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this,LoginActivity.class);
                startActivityForResult(intent,168);
            }
        });

        productlist = findViewById(R.id.productlist);
        productlist.setAdapter(new ProductsAdapter(laptopNames,laptopImages));
        productlist.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==168){
            if (resultCode==RESULT_OK){
                ((TextView)findViewById(R.id.guest)).setText(data.getStringExtra("username"));
            }
        }
    }
}