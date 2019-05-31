package com.example.verdinhoo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_activity_1);




        String nome = getIntent().getStringExtra("Nome");
        String produto = getIntent().getStringExtra("Produto");
        TextView textViewNome = findViewById(R.id.textViewNome);
        TextView textViewProduto = findViewById(R.id.textViewProduto);
        ImageView image = findViewById(R.id.image);



        Bitmap bmp;

        byte[] byteArray = getIntent().getByteArrayExtra("Image");
        bmp = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);

        textViewProduto.setText(produto);
        textViewNome.setText(nome);
        image.setImageBitmap(bmp);

    }

}
