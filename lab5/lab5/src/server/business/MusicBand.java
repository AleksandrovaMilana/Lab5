package server.business;

public class MusicBand implements Comparable<MusicBand>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    public String getName() {
        return name;
    }

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    private Integer numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private int singlesCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null

    public Studio getStudio() {
        return studio;
    }

    private Studio studio; //Поле может быть null

    public MusicBand(Long id,
                     String name,
                     Coordinates coordinates,
                     java.time.LocalDate creationDate,
                     Integer numberOfParticipants,
                     int singlesCount,
                     MusicGenre genre,
                     Studio studio)
    {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.studio = studio;
    }

    public long getId(){
        return id;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", singlesCount=" + singlesCount +
                ", genre=" + genre +
                ", studio=" + studio +
                '}';
    }

    @Override
    public int compareTo(MusicBand o) {
        if(o == null)
            return 1;
        return this.name.compareTo(o.getName());
    }
}

