package client.util;

public class FieldValidators {

    static public boolean validateMusicBandName(String musicBandName)
    {
        return  musicBandName != null && !musicBandName.isEmpty();
    }

    static public boolean validateMusicBandCoordinatesX(Float x)
    {
        return x != null;
    }

    static public boolean validateMusicBandCoordinatesY(Double y)
    {
        return y != null;
    }

    static public boolean validateMusicBandNumberOfParticipants(Integer numberOfParticipants)
    {
        return numberOfParticipants != null && numberOfParticipants > 0;
    }


    public static boolean validateMusicBandsSinglesCount(int singlesCount) {
        return singlesCount > 0;
    }

    static public boolean validateMusicBandStudioName(String studioName)
    {
        return  studioName != null;
    }

    static public boolean validateMusicBandMusicGenre(String musicGenre)
    {
        return musicGenre.equals("BLUES") ||
                musicGenre.equals("MATH_ROCK") ||
                musicGenre.equals("BRIT_POP");
    }
}
