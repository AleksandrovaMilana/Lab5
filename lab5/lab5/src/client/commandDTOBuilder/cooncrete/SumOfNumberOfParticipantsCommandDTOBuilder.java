package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.SumOfNumberOfParticipantsCommandDTO;

public class SumOfNumberOfParticipantsCommandDTOBuilder implements CommandDTOBuilder {
    public SumOfNumberOfParticipantsCommandDTOBuilder(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {

    }

    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        return new SumOfNumberOfParticipantsCommandDTO();
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {
        return new SumOfNumberOfParticipantsCommandDTO();
    }
}
