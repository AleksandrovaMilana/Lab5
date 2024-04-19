package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveAtCommandExecutionResultDTO;

public class RemoveAtCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        RemoveAtCommandExecutionResultDTO removeAtCommandExecutionResultDTO
                = (RemoveAtCommandExecutionResultDTO) commandExecutionResultDTO;


        return "Музыкальная группа с index = " + removeAtCommandExecutionResultDTO.getIndex() + " была удалена";
    }
}
