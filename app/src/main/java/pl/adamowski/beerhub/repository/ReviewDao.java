package pl.adamowski.beerhub.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import pl.adamowski.beerhub.models.Review;

@Dao
public interface ReviewDao {

    @Query("SELECT * FROM Review")
    List<Review> getAll();

    @Insert
    long saveInDataBase(Review review);

    @Delete
    void deleteInDatabase(Review review);
}