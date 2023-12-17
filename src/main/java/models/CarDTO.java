package models;

public class CarDTO implements CarDTOInterface{

    private int id;
    private String make;
    private String model;
    private String year;
    private String color;
    private int vin;

    public CarDTO () {
    }

    public CarDTO(String make, String model, String year, String color, int vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }
    public CarDTO(int id, String make, String model, String year, String color, int vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    @Override
    public int getID() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }
}
