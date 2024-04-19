package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.util.FieldValidators;
import client.util.MusicBandFieldGetter;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.RemoveAtCommandDTO;
import contract.dto.commanddto.concrete.RemoveByIdCommandDTO;

public class RemoveByIdCommandDTOBuilder implements CommandDTOBuilder {


    private MusicBandFieldGetter musicBandGetter;

    public RemoveByIdCommandDTOBuilder(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.musicBandGetter = new MusicBandFieldGetter(consoleReader, consoleWriter);
    }

    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        long id;
        if (!FieldValidators.validateMusicBandId(commandArguments[0]))
            id = musicBandGetter.getMusicBandId();
        else
            id = Long.parseLong(commandArguments[0]);

        return new RemoveByIdCommandDTO(id);
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {
        if (
                !FieldValidators.validateMusicBandId(commandArgument.trim())

        ){
            System.out.println("При выполнении скрипта аргумент команды remove_by_id не прошел валидацию. Скрипт не будет выполнен");
            throw new InvalidCommandArgumentsInScriptFileException();
        }

        long id = Long.parseLong(commandArgument.trim());

        return new RemoveByIdCommandDTO(id);
    }
}
