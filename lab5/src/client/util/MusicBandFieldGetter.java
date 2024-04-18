package client.util;

import client.io.ConsoleReader;
import client.io.ConsoleWriter;

public class MusicBandFieldGetter
{
    private ConsoleReader consoleReader;
    private ConsoleWriter consoleWriter;

    public MusicBandFieldGetter(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public long getMusicBandId()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите id музыкальной группы:");
            String idSting = consoleReader.getNextLine();
            long id = 0;
            try {
                id = Long.parseLong(idSting);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("id должен быть целым числом");
                continue;
            }
            if (FieldValidators.validateMusicBandId(id))
                return id;
        }
    }

    public int getMusicBandIndex()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите index музыкальной группы:");
            String indexSting = consoleReader.getNextLine();
            int index = 0;
            try {
                index = Integer.parseInt(indexSting);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("index должен быть целым числом");
                continue;
            }
            if (FieldValidators.validateMusicBandIndex(index))
                return index;
        }
    }

    public String getMusicBandName()
    {
        while (true)
        {
            consoleWriter.printlnToOutputStream("Ведите название музыкальной группы:");
            String name = consoleReader.getNextLine();
            if (FieldValidators.validateMusicBandName(name))
                return name;
            else
                consoleWriter.printlnToOutputStream("Название музыкльной группы не может быть null и не может быть пустым");
        }
    }

    public float getMusicBandCoordinatesX()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите координату x музыкальной группы:");
            String xSting = consoleReader.getNextLine();
            float x = 0;
            try {
                x = Float.parseFloat(xSting);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("x должен быть числом с плавающей точкой");
                continue;
            }
            if (FieldValidators.validateMusicBandCoordinatesX(x))
                return x;
        }
    }

    public double getMusicBandCoordinatesY()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите координату y музыкальной группы:");
            String ySting = consoleReader.getNextLine();
            Double y = 0.0;
            try {
                y = Double.parseDouble(ySting);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("y должен быть числом с плавающей точкой");
                continue;
            }
            if (FieldValidators.validateMusicBandCoordinatesY(y))
                return y;
        }
    }

    public Integer getMusicBandNumberOfParticipants()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите число участников музыкальной группы:");
            String numberOfParticipantsSting = consoleReader.getNextLine();
            Integer numberOfParticipants = 0;
            try {
                numberOfParticipants = Integer.parseInt(numberOfParticipantsSting);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("Число участников должно быть целым");
                continue;
            }
            if (FieldValidators.validateMusicBandNumberOfParticipants(numberOfParticipants))
                return numberOfParticipants;
            else
                consoleWriter.printlnToOutputStream("Число участников должно быть больше 0");
        }
    }

    public int getMusicBandSinglesCount()
    {
        while (true) {
            consoleWriter.printlnToOutputStream("Ведите число синглов музыкальной группы:");
            String singlesCountString = consoleReader.getNextLine();
            int singlesCount = 0;
            try {
                singlesCount = Integer.parseInt(singlesCountString);
            }
            catch (NumberFormatException numberFormatException)
            {
                consoleWriter.printlnToOutputStream("Число синглов должно быть целым");
                continue;
            }
            if (FieldValidators.validateMusicBandsSinglesCount(singlesCount))
                return singlesCount;
            else
                consoleWriter.printlnToOutputStream("Число синглов должно быть больше 0");
        }
    }

    public String getMusicBandStudioName()
    {
        while (true)
        {
            consoleWriter.printlnToOutputStream("Ведите название студии музыкальной группы:");
            String studioName = consoleReader.getNextLine();
            if (FieldValidators.validateMusicBandStudioName(studioName))
                return studioName;
            else
                consoleWriter.printlnToOutputStream("Название музыкльной группы не может быть null");
        }
    }

    public String getMusicBandMusicGenre()
    {
        while (true)
        {
            consoleWriter.printlnToOutputStream("Ведите жанр музыкальной группы:");
            String musicGenre = consoleReader.getNextLine();
            if (FieldValidators.validateMusicBandMusicGenre(musicGenre))
                return musicGenre;
            else
                consoleWriter.printlnToOutputStream("Жанр группы должен быть одним из значений: BLUES, MATH_ROCK, BRIT_POP");
        }
    }








}
