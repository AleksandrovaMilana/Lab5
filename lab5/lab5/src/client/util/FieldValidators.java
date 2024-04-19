package client.util;

public class FieldValidators {

    static public boolean validateMusicBandIndex(Integer index)
    {
        return true;
    }

    static public boolean validateMusicBandIndex(String indexString)
    {
        int index;
        try {
            index = Integer.parseInt(indexString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandIndex(index);
    }

    static public boolean validateMusicBandId(Long id)
    {
        return true;
    }

    static public boolean validateMusicBandId(String idString)
    {
        long id;
        try {
            id = Long.parseLong(idString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandId(id);
    }

    static public boolean validateMusicBandName(String musicBandName)
    {
        return  musicBandName != null && !musicBandName.isEmpty();
    }

    static public boolean validateMusicBandCoordinatesX(Float x)
    {
        return x != null;
    }

    static public boolean validateMusicBandCoordinatesX(String xString)
    {
        float x;
        try {
            x = Float.parseFloat(xString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandCoordinatesX(x);
    }

    static public boolean validateMusicBandCoordinatesY(Double y)
    {
        return y != null;
    }

    static public boolean validateMusicBandCoordinatesY (String yString)
    {
        double y;
        try {
            y = Double.parseDouble(yString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandCoordinatesY(y);
    }

    static public boolean validateMusicBandNumberOfParticipants(Integer numberOfParticipants)
    {
        return numberOfParticipants != null && numberOfParticipants > 0;
    }

    static public boolean validateMusicBandNumberOfParticipants(String numberOfParticipantsString)
    {
        int numberOfParticipants;
        try {
            numberOfParticipants = Integer.parseInt(numberOfParticipantsString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandNumberOfParticipants(numberOfParticipants);
    }


    public static boolean validateMusicBandsSinglesCount(int singlesCount) {
        return singlesCount > 0;
    }

    static public boolean validateMusicBandsSinglesCount(String singlesCountString)
    {
        int singlesCount;
        try {
            singlesCount = Integer.parseInt(singlesCountString);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return validateMusicBandsSinglesCount(singlesCount);
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
