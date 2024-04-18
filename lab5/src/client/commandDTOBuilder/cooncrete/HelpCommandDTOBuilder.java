package client.commandDTOBuilder.cooncrete;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.HelpCommandDTO;

public class HelpCommandDTOBuilder implements CommandDTOBuilder {

    public CommandDTO buildCommandDTO(String[] arguments)
    {
        return new  HelpCommandDTO();
    }

    @Override
    public CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException {
        return new HelpCommandDTO();
    }


}
