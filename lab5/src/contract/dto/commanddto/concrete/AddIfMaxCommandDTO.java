package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class AddIfMaxCommandDTO implements CommandDTO {
    @Override
    public String getCommandName() {
        return "add_if_max";
    }

    private String musicBandName;
    private Float musicBandCoordinatesX;
    private Double musicBandCoordinatesY;
    private Integer musicBandNumberOfParticipants;
    private int musicBandSinglesCount;
    private String musicBandStudioName;
    private String musicBandMusicGenre;

    public AddIfMaxCommandDTO(String musicBandName,
                              Float musicBandCoordinatesX,
                              Double musicBandCoordinatesY,
                              Integer musicBandNumberOfParticipants,
                              int musicBandSinglesCount,
                              String musicBandStudioName,
                              String musicBandMusicGenre){
        this.musicBandName = musicBandName;
        this.musicBandCoordinatesX = musicBandCoordinatesX;
        this.musicBandCoordinatesY = musicBandCoordinatesY;
        this.musicBandNumberOfParticipants = musicBandNumberOfParticipants;
        this.musicBandSinglesCount = musicBandSinglesCount;
        this.musicBandStudioName = musicBandStudioName;
        this.musicBandMusicGenre = musicBandMusicGenre;
    }

    public String getMusicBandName() {
        return musicBandName;
    }

    public Float getMusicBandCoordinatesX() {
        return musicBandCoordinatesX;
    }

    public Double getMusicBandCoordinatesY() {
        return musicBandCoordinatesY;
    }

    public Integer getMusicBandNumberOfParticipants() {
        return musicBandNumberOfParticipants;
    }

    public int getMusicBandSinglesCount() {
        return musicBandSinglesCount;
    }

    public String getMusicBandStudioName() {
        return musicBandStudioName;
    }

    public String getMusicBandMusicGenre() {
        return musicBandMusicGenre;
    }


}
