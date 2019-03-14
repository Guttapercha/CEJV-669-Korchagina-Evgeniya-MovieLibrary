package com.example.movielibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button b1 = findViewById(R.id.button_back);
        Button b2 = findViewById(R.id.button_save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                setResult(2, i);
                Main2Activity.this.finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                EditText name = findViewById(R.id.name);
                RatingBar rating = findViewById(R.id.rating);
                if (!(name.getText().toString()).isEmpty()) {
                    i.putExtra("name", name.getText().toString());
                    rating.setNumStars(5);
                    i.putExtra("rating", Float.toString(rating.getRating()));
                    setResult(1, i);
                } else {
                    setResult(2, i);
                }
                Main2Activity.this.finish();
            }
        });
    }
}
