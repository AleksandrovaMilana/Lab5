package server.business;

public class Coordinates {
    private Float x; //Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates (Float x, Double y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
