package pl.adamowski.beerhub;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import pl.adamowski.beerhub.models.Review;
import pl.adamowski.beerhub.repository.ReviewDao;

@Database(entities = {Review.class}, version = 3)
public abstract class BeerDataBase extends RoomDatabase {
    public abstract ReviewDao reviewDao();
}