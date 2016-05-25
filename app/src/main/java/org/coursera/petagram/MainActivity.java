package org.coursera.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        pets.add(new Pet(R.drawable.dog, "Matías", 0));
        pets.add(new Pet(R.drawable.dog2, "Nisha", 0));
        pets.add(new Pet(R.drawable.dog, "Sebastián", 0));
        pets.add(new Pet(R.drawable.dog2, "Pirata", 0));
        pets.add(new Pet(R.drawable.dog, "Señora Gorda", 0));
        pets.add(new Pet(R.drawable.dog2, "Lola", 0));
        pets.add(new Pet(R.drawable.dog, "Rocky", 0));
        pets.add(new Pet(R.drawable.dog2, "Fifí", 0));
        pets.add(new Pet(R.drawable.dog, "Doby", 0));

        // Adapter instantiation
        PetAdapter petAdapter = new PetAdapter(pets);
        rvPets.setAdapter(petAdapter);
    }
}
