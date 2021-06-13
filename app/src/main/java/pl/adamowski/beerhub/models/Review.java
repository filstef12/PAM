package pl.adamowski.beerhub.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Review {
    @PrimaryKey(autoGenerate = true)
    public Integer id;
    public String Name;
    public String Brewery;
    public String Style;
    public String Comment;

    public Review(){

    }

    public Review(Integer id, String Name, String Brewery, String Style, String Comment) {
        this.id = id;
        this.Name = Name;
        this.Brewery = Brewery;
        this.Style = Style;
        this.Comment = Comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrewery() {
        return Brewery;
    }

    public void setBrewery(String brewery) {
        Brewery = brewery;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }


    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }


}