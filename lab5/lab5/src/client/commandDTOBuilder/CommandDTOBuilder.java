package client.commandDTOBuilder;

import client.exeptions.InvalidCommandArgumentsInScriptFileException;
import client.exeptions.RecursiveScriptExecutionException;
import client.util.StringIterator;
import contract.dto.commanddto.CommandDTO;

public interface CommandDTOBuilder
{
    CommandDTO buildCommandDTO(String[] commandArguments);
    CommandDTO buildCommandDTOFromScript(String[] fileStrings, StringIterator stringIterator, String commandArgument) throws InvalidCommandArgumentsInScriptFileException, RecursiveScriptExecutionException;
}
