package pl.adamowski.beerhub;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.adamowski.beerhub.adapters.ReviewListAdapter;
import pl.adamowski.beerhub.models.Review;
import pl.adamowski.beerhub.repository.ReviewDao;

public class ReviewsListActivity extends AppCompatActivity {

    private ReviewDao reviewDao;
    private List<Review> allReviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BeerDataBase database = BeerApplication.getINSTANCE();
        ReviewDao reviewDao = database.reviewDao();
        allReviews = reviewDao.getAll();

        for (Review s : allReviews) {
            Log.d("Comment: ", String.valueOf(s));
        }

        ReviewListAdapter reviewListAdapter = new ReviewListAdapter(allReviews);
        RecyclerView reviewRecyclerView = (RecyclerView) findViewById(R.id.review_list_recycler_view);
        reviewRecyclerView.setAdapter(reviewListAdapter);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //utworzenie obiektu ItemTouchHelper
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                final int position = viewHolder.getAdapterPosition();
                AlertDialog.Builder builder = new AlertDialog.Builder(viewHolder.itemView.getContext()).setMessage("Czy na pewno chcesz usunąć recenzję?");

                builder.setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button

                        Review reviewToDelete = reviewListAdapter.getReview(position);
                        reviewDao.deleteInDatabase(reviewToDelete);
                        allReviews.remove(position);
                        reviewListAdapter.notifyItemRemoved(position);
                        Toast.makeText(ReviewsListActivity.this, "Usunięto recenzję", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        reviewListAdapter.notifyItemRangeChanged(position, reviewListAdapter.getItemCount());
                        Toast.makeText(ReviewsListActivity.this, "Anulowano usuniecie", Toast.LENGTH_SHORT).show();
                    }
                })
                        .create()
                        .show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(reviewRecyclerView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
