package Corsi;

public class Corso {
    private int id;
    private String title;
    private String description;
    private double cost;
    private int numHours;

    public Corso(int id, String title, String description, double cost, int numHours){
        this.id = id;
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.numHours = numHours;
    }

    public Corso(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    @Override
    public String toString() {
        return "Corsi{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", numHours=" + numHours +
                '}';
    }
}
