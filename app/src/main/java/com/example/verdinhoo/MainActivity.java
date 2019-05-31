package com.example.verdinhoo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Hygor José Silva", "Robson Arantes", "Carlos Freire", "Marília Moura", "Heloísa Alves"};
    String mDescription[] = {"Hidratante", "Shampo", "Hidrante Shampo Repelente", "Hidrante Repelente" , "Sabonete Repelente"};

    int image[] = {R.drawable.homem1, R.drawable.homem2, R.drawable.homem3, R.drawable.mulher1, R.drawable.mulher2};


   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ByteArrayOutputStream bStream = new ByteArrayOutputStream();

                Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),image[position]);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,bStream);
                byte[] byteArray = bStream.toByteArray();

                Intent myIntent = new Intent(getBaseContext()
                        , ListItemActivity1.class);
                myIntent.putExtra("Nome", mTitle[position]);
                myIntent.putExtra("Produto", mDescription[position]);
                myIntent.putExtra("Image", byteArray);

                startActivity(myIntent);
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int[] rImgs;

        MyAdapter(Context c, String title[], String description[], int[] imgs){
            super(c,R.layout.row, R.id.textView1,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
