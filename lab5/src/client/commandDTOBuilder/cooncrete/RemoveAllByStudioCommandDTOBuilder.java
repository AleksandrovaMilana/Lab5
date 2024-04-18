package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.util.FieldValidators;
import client.util.MusicBandFieldGetter;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.RemoveAllByStudioCommandDTO;

public class RemoveAllByStudioCommandDTOBuilder implements CommandDTOBuilder {
    private MusicBandFieldGetter musicBandGetter;

    public RemoveAllByStudioCommandDTOBuilder(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.musicBandGetter = new MusicBandFieldGetter(consoleReader, consoleWriter);
    }

    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        String musicBandStudioName = musicBandGetter.getMusicBandStudioName();
        return new RemoveAllByStudioCommandDTO(musicBandStudioName);
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {

        String musicBandStudioNameString = commandArgument.trim();

        if (

                !FieldValidators.validateMusicBandStudioName(musicBandStudioNameString)

        ){
            System.out.println("error");
            throw new InvalidCommandArgumentsInScriptFileException();
        }

        String musicBandStudioName = musicBandStudioNameString;


        return new RemoveAllByStudioCommandDTO(musicBandStudioName);
    }
}
