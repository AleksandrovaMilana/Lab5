package client;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import client.exeptions.ExitException;
import client.util.ClientInitializer;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

import java.util.Map;

public class OutputStringBuilder
{
    private final Map<String, CommandExecutionResultHandler> commandExecutionResultDTOHandlers;
    public OutputStringBuilder()
    {
        this.commandExecutionResultDTOHandlers = ClientInitializer.initializeCommandExecutionResultDTOHandlers();
    }

    public String buildOutputString(CommandExecutionResultDTO commandExecutionResultDTO) throws ExitException {
        return this.commandExecutionResultDTOHandlers.get(commandExecutionResultDTO.getCommandName())
                .handleServerResponse(commandExecutionResultDTO);
    }
}
