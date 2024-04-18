package server.business;

public class Studio {
    public String getName() {
        return name;
    }

    private String name;
    public  Studio(String name){
        this.name = name;
    }//Поле может быть null

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                '}';
    }
}
