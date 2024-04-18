package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.SortCommandDTO;

public class SortCommandDTOBuilder implements CommandDTOBuilder {
    @Override
    public CommandDTO buildCommandDTO(String[] commandArguments) {
        return new SortCommandDTO();
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {
        return new SortCommandDTO();
    }
}
