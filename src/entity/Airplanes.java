package entity;

public class Airplanes {

    public int id;
    public String model;
    public int capacity;

    public Airplanes() {
    }

    public Airplanes(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", model: " + model +
                ", capacity: " + capacity + " passengers";
    }
}
