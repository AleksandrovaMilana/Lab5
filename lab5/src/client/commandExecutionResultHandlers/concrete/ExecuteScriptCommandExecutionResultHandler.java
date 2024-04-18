package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import client.exeptions.ExitException;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.ExecuteScriptCommandExecutionResultDTO;

import java.util.Map;

public class ExecuteScriptCommandExecutionResultHandler implements CommandExecutionResultHandler
{
    private final Map<String, CommandExecutionResultHandler> serverResponseHandlerMap;

    public ExecuteScriptCommandExecutionResultHandler(Map<String, CommandExecutionResultHandler> serverResponseHandlerMap)
    {
        this.serverResponseHandlerMap = serverResponseHandlerMap;
    }

    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) throws ExitException {
        ExecuteScriptCommandExecutionResultDTO executeScriptCommandExecutionResultDTO =
                (ExecuteScriptCommandExecutionResultDTO) commandExecutionResultDTO;
        String output = "";
        try {


        for (CommandExecutionResultDTO commandExecutionResultDTO1:
                executeScriptCommandExecutionResultDTO
                        .getCommandExecutionResultDTOList() )
        {
            output = output.concat(
                    this.serverResponseHandlerMap
                            .get(commandExecutionResultDTO1.getCommandName())
                            .handleServerResponse(commandExecutionResultDTO1).concat("\n")
            );
        }
        } catch (ExitException exception)
        {
            throw new ExitException(output);
        }


        return output + "Скрипт завершил выполнение";
    }
}
