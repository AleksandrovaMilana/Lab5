package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.RemoveAtCommandDTO;
import contract.dto.commanddto.concrete.RemoveByIdCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveAtCommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveByIdCommandExecutionResultDTO;
import server.CollectionManager;
import server.commandexecutors.CommandExecutor;

public class RemoveAtCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;

    public RemoveAtCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        RemoveAtCommandDTO removeAtCommandDTO = (RemoveAtCommandDTO) commandDTO;
        int index = removeAtCommandDTO.getIndex();
        collectionManager.removeByIndex(index);
        return new RemoveAtCommandExecutionResultDTO(index);
    }
}
