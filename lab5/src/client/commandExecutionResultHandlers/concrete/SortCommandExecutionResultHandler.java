package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SortCommandExecutionResultDTO;

public class SortCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        SortCommandExecutionResultDTO sortCommandExecutionResultDTO
                = (SortCommandExecutionResultDTO) commandExecutionResultDTO;


        return sortCommandExecutionResultDTO.getCommandExecutionResultMessage();
    }
}
