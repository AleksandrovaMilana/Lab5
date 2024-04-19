package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.UpdateCommandExecutionResultDTO;

public class UpdateCommandExecutionResultHandler implements CommandExecutionResultHandler {


    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        UpdateCommandExecutionResultDTO updateCommandExecutionResultDTO =
                (UpdateCommandExecutionResultDTO) commandExecutionResultDTO;
        if (updateCommandExecutionResultDTO.isMusicBandRemovedByCommandExecution())
            return "Музыкальная группа с Id = " + updateCommandExecutionResultDTO.getId() + " обновлена";
        else return "Обновление не выполнено, музыкальная группа с id = " +
                updateCommandExecutionResultDTO.getId() + " не обновлена";
    }
}
