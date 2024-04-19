package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SaveCommandExecutionResultDTO;

public class SaveCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        SaveCommandExecutionResultDTO saveCommandExecutionResultDTO
                = (SaveCommandExecutionResultDTO) commandExecutionResultDTO;


        return saveCommandExecutionResultDTO.getMsg();
    }
}
