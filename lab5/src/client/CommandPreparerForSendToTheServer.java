package client;

import client.commandDTOBuilder.CommandDTOBuilder;
import client.exeptions.UnknownCommandException;
import client.io.ConsoleReader;
import client.io.ConsoleWriter;
import client.util.ClientInitializer;
import contract.dto.commanddto.CommandDTO;

import java.util.Map;

public class CommandPreparerForSendToTheServer
{
    private final Map<String, CommandDTOBuilder> commandDTOBuilders;
    public CommandPreparerForSendToTheServer(ConsoleReader consoleReader, ConsoleWriter consoleWriter)
    {
        this.commandDTOBuilders = ClientInitializer.initializeCommandDTOBuilders(consoleReader, consoleWriter);
    }

    public CommandDTO prepareCommandDTOForSending(String commandName, String[] commandArguments) throws UnknownCommandException {
        if (commandDTOBuilders.get(commandName) == null)
            throw new UnknownCommandException();
    return commandDTOBuilders.get(commandName).buildCommandDTO(commandArguments);
    }
}
