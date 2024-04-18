package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.CountByStudioCommandExecutionResultDTO;

public class CountByStudioCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        CountByStudioCommandExecutionResultDTO countByStudioCommandExecutionResultDTO
                = (CountByStudioCommandExecutionResultDTO) commandExecutionResultDTO;


        return "Количество элементов, значение поля studio которых равно заданному = " + countByStudioCommandExecutionResultDTO.getCount();
    }
}
