package org.coursera.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                break;
            case R.id.mSettings:
                break;
            case R.id.mStar:
                Intent intent = new Intent(this, BestFive.class);
                intent = AddBestFive(intent);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Intent AddBestFive(Intent intent){
        int[] ordered_by_rating = new int[pets.size()];
        for (int i=0;i<ordered_by_rating.length;i++){
            ordered_by_rating[i] = i;
        }
        for (int i=0;i<pets.size();i++){
            for (int j=0;j<pets.size();j++){
                if (pets.get(ordered_by_rating[i]).getRate() >= pets.get(ordered_by_rating[j]).getRate()){
                    int temp = ordered_by_rating[i];
                    ordered_by_rating[i] = ordered_by_rating[j];
                    ordered_by_rating[j] = temp;
                }
            }
        }
        for (int i=0;i<5;i++){
            intent.putExtra("foto" + i, pets.get(ordered_by_rating[i]).getFoto());
            intent.putExtra("name" + i, pets.get(ordered_by_rating[i]).getName());
            intent.putExtra("rate" + i, pets.get(ordered_by_rating[i]).getRate());
        }
        return intent;
    }
}
