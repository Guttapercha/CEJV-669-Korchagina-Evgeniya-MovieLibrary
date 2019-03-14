package com.example.movielibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movies> moviesList = new ArrayList<>();
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler = findViewById(R.id.recycle);
        movieAdapter = new MovieAdapter(moviesList);

        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recycler.setAdapter(movieAdapter);
        moviesList.addAll(generateData());


        Button b1 = findViewById(R.id.btn_add_record);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivityForResult(i, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1 && requestCode == 0) {

            if (data.hasExtra("name") && data.hasExtra("rating")) {
                Movies m;
                m = new Movies(data.getExtras().getString("name"), (int) Double.parseDouble(data.getExtras().getString("rating")));
                moviesList.add(m);
                movieAdapter.notifyDataSetChanged();
                Toast.makeText(this, "movie "+m.getMovieName()+ " added", Toast.LENGTH_LONG).show();
            }

        }   else {
            Toast.makeText(this, "adding cancelled", Toast.LENGTH_LONG).show();
        }
    }

    protected ArrayList<Movies> generateData ()
    {
        ArrayList<Movies> alm = new ArrayList<>();

        Movies m;

        m = new Movies("Gone with the wind", 5);
        alm.add(m);
        m = new Movies("Friends", 5);
        alm.add(m);
        m = new Movies("Moby Dick", 4);
        alm.add(m);

        return alm;
    }

}
