package org.example.ZADACHKA1;

public class GenericCar<T> {
    private String model;
    private String color;

    public GenericCar(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}
