package client.commandpreparers;

import client.ConsoleReader;
import client.ConsoleWriter;
import client.util.MusicBandFieldGetter;
import contract.command.AddCommandDTO;
import contract.command.CommandDTO;

public class AddCommandPreparer implements CommandPreparer
{
    private ConsoleReader consoleReader;
    private ConsoleWriter consoleWriter;

    private MusicBandFieldGetter musicBandGetter;

    public AddCommandPreparer(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.musicBandGetter = new MusicBandFieldGetter(consoleReader, consoleWriter);
    }

    @Override
    public CommandDTO prepareCommand(String[] arguments)
    {

        String musicBandName = musicBandGetter.getMusicBandName();
        Float musicBandCoordinatesX = musicBandGetter.getMusicBandCoordinatesX();
        Double musicBandCoordinatesY = musicBandGetter.getMusicBandCoordinatesY();
        Integer musicBandNumberOfParticipants = musicBandGetter.getMusicBandNumberOfParticipants();
        int musicBandSinglesCount = musicBandGetter.getMusicBandSinglesCount();
        String musicBandStudioName = musicBandGetter.getMusicBandStudioName();
        String musicBandMusicGenre = musicBandGetter.getMusicBandMusicGenre();





        return new AddCommandDTO(musicBandName,
                musicBandCoordinatesX,
                musicBandCoordinatesY,
                musicBandNumberOfParticipants,
                musicBandSinglesCount,
                musicBandStudioName,
                musicBandMusicGenre);
    }


}
