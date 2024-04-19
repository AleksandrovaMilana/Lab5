package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class UpdateCommandDTO implements CommandDTO {private String musicBandName;

    public long getId() {
        return id;
    }

    private final long id;
    private final Float musicBandCoordinatesX;
    private final Double musicBandCoordinatesY;
    private final Integer musicBandNumberOfParticipants;
    private final int musicBandSinglesCount;
    private final String musicBandStudioName;
    private final String musicBandMusicGenre;

    public UpdateCommandDTO(long id,
                            String musicBandName,
                         Float musicBandCoordinatesX,
                         Double musicBandCoordinatesY,
                         Integer musicBandNumberOfParticipants,
                         int musicBandSinglesCount,
                         String musicBandStudioName,
                         String musicBandMusicGenre){
        this.id = id;
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

    @Override
    public String getCommandName() {
        return "update";
    }
}
