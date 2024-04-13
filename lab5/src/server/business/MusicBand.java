package server.business;

public class MusicBand {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private int singlesCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
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
}
