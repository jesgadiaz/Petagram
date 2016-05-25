package org.coursera.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by rodomualdo on 25/05/2016.
 */
public class BestFive extends AppCompatActivity{

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar
        toolbar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(toolbar);

        // RecyclerView
        rvPets = (RecyclerView) findViewById(R.id.rvPets);

        //Layout Manager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        // Set Layout Manager
        rvPets.setLayoutManager(llm);

        // Hardcoded data
        pets = new ArrayList<>();
        Intent intent = getIntent();
        for (int i=0;i<5;i++){
            pets.add(new Pet(intent.getIntExtra("foto" + i, 0), intent.getStringExtra("name" + i), intent.getIntExtra("rate" + i, 0)));
        }

        // Adapter instantiation
        PetAdapter petAdapter = new PetAdapter(pets);
        rvPets.setAdapter(petAdapter);
    }
}
