package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.ExitCommandDTO;

public class ExitCommandDTOBuilder implements CommandDTOBuilder {
    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        return new ExitCommandDTO();
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {
        return new ExitCommandDTO();
    }
}
