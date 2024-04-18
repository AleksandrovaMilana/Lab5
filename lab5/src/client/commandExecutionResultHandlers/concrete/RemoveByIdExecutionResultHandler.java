package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveByIdCommandExecutionResultDTO;

public class RemoveByIdExecutionResultHandler implements CommandExecutionResultHandler {


    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        RemoveByIdCommandExecutionResultDTO removeByIdCommandExecutionResultDTO =
                (RemoveByIdCommandExecutionResultDTO) commandExecutionResultDTO;
        if (removeByIdCommandExecutionResultDTO.isMusicBandRemovedByCommandExecution())
            return "Музыкальная группа с Id = " + removeByIdCommandExecutionResultDTO.getId() + " была удалена";
        else return "Удаление не выполнено, так как в коллекции нет музыкальной группы с id = " +
                removeByIdCommandExecutionResultDTO.getId();
    }
}
