package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveAllByStudioCommandExecutionResultDTO;

public class RemoveAllByStudioCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        RemoveAllByStudioCommandExecutionResultDTO removeAllByStudioCommandExecutionResultDTO
                = (RemoveAllByStudioCommandExecutionResultDTO) commandExecutionResultDTO;

        if (removeAllByStudioCommandExecutionResultDTO.isMusicBandRemovedByCommandExecution())
            return "Музыкальные группы со studioName = " + removeAllByStudioCommandExecutionResultDTO.getStudioName() + " были удалены";
        else return "Удаление не выполнено, так как в коллекции нет музыкальных групп сo studioName = " +
                removeAllByStudioCommandExecutionResultDTO.getStudioName();

    }
}
