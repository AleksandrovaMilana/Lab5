package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.AddIfMaxCommandExecutionResultDTO;

public class AddIfMaxCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        AddIfMaxCommandExecutionResultDTO addIfMaxCommandExecutionResultDTO
                = (AddIfMaxCommandExecutionResultDTO) commandExecutionResultDTO;


        return addIfMaxCommandExecutionResultDTO.getCommandExecutionResultMessage();
    }
}
