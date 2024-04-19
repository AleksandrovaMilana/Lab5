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
import contract.dto.commanddto.concrete.RemoveAtCommandDTO;
import contract.dto.commanddto.concrete.RemoveByIdCommandDTO;
import contract.dto.commanddto.concrete.UpdateCommandDTO;

public class RemoveAtCommandDTOBuilder implements CommandDTOBuilder {

    private MusicBandFieldGetter musicBandGetter;

    public RemoveAtCommandDTOBuilder(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.musicBandGetter = new MusicBandFieldGetter(consoleReader, consoleWriter);
    }

    public CommandDTO buildCommandDTO(String[] commandArguments) {
        int index;
        if (!FieldValidators.validateMusicBandIndex(commandArguments[0]))
            index = musicBandGetter.getMusicBandIndex();
        else
            index = Integer.parseInt(commandArguments[0]);

        return new RemoveAtCommandDTO(index);
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {

        if (
                !FieldValidators.validateMusicBandIndex(commandArgument.trim())

        ){
            System.out.println("При выполнении скрипта аргумент команды remove_at не прошел валидацию. Скрипт не будет выполнен");
            throw new InvalidCommandArgumentsInScriptFileException();
        }

        int index = Integer.parseInt(commandArgument.trim());

        return new RemoveAtCommandDTO(index);
    }
}
