package pl.adamowski.beerhub;
import androidx.room.Room;

import pl.adamowski.beerhub.models.Beer;

public class BeerApplication extends android.app.Application{

    private static BeerDataBase INSTANCE;

    public static BeerDataBase getINSTANCE() {return INSTANCE;}

    @Override
    public void onCreate (){
        super.onCreate();
        INSTANCE = Room.databaseBuilder(getApplicationContext(),
                BeerDataBase.class, "BeerDataBase")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
