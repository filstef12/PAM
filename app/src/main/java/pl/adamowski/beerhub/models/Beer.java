package pl.adamowski.beerhub.models;

public class Beer {


    private String name;
    private String brewery;
    private String style;
    public int dupa;

    public Beer() {
    }


    public Beer(String name, String brewery, String style) {
        this.name = name;
        this.brewery = brewery;
        this.style = style;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String toString() {
        return "Beer{" +
                "Name='" + name + '\'' +
                ", brewery='" + brewery + '\'' +
                ", style=" + style +
                '}';
    }

}
