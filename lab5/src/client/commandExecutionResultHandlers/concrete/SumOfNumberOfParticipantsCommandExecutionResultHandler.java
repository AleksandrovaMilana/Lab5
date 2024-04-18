package client.commandExecutionResultHandlers.concrete;

import client.commandExecutionResultHandlers.CommandExecutionResultHandler;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SumOfNumberOfParticipantsCommandExecutionResultDTO;

public class SumOfNumberOfParticipantsCommandExecutionResultHandler implements CommandExecutionResultHandler {
    @Override
    public String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) {
        SumOfNumberOfParticipantsCommandExecutionResultDTO sumOfNumberOfParticipantsCommandExecutionResultDTO
                = (SumOfNumberOfParticipantsCommandExecutionResultDTO) commandExecutionResultDTO;


        return "Сумма значений поля numberOfParticipants для всех элементов коллекции = " + sumOfNumberOfParticipantsCommandExecutionResultDTO.getSum();
    }
}
