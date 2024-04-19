package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.SumOfNumberOfParticipantsCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SumOfNumberOfParticipantsCommandExecutionResultDTO;
import server.CollectionManager;
import server.commandexecutors.CommandExecutor;

public class SumOfNumberOfParticipantsCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;
    public SumOfNumberOfParticipantsCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        SumOfNumberOfParticipantsCommandDTO sumOfNumberOfParticipantsCommandDTO = (SumOfNumberOfParticipantsCommandDTO) commandDTO;


        return new SumOfNumberOfParticipantsCommandExecutionResultDTO(collectionManager.sumOOfNumberOfParticipants());
    }
}
