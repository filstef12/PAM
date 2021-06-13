package pl.adamowski.beerhub;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import pl.adamowski.beerhub.adapters.BeersListAdapter;
import pl.adamowski.beerhub.models.Beer;

public class BeerListActivity extends AppCompatActivity {

    List<Beer> beers = new ArrayList<>();
    public BeerListActivity() throws ParseException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Beer piwo1 = new Beer ("Dupa","Poslady","dada");
        Beer piwo2 = new Beer ("Ddas","Poffdy","daasdfda");

        beers.add(piwo1);
        beers.add(piwo2);

        for (Beer i : beers){
            Log.d("Lista zawiera piwo: ",i.toString());
        }

        BeersListAdapter beersListAdapter = new BeersListAdapter(beers);

        RecyclerView beerRecyclerView = (RecyclerView) findViewById(R.id.beers_list_recycler_view);

        beerRecyclerView.setAdapter(beersListAdapter);
        beerRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
