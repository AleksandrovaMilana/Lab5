package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.RemoveAllByStudioCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveAllByStudioCommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.RemoveByIdCommandExecutionResultDTO;
import server.CollectionManager;
import server.commandexecutors.CommandExecutor;

public class RemoveAllByStudioCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;
    public RemoveAllByStudioCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        RemoveAllByStudioCommandDTO removeAllByStudioCommandDTO = (RemoveAllByStudioCommandDTO) commandDTO;
        String studioName = removeAllByStudioCommandDTO.getStudioName();
        return new RemoveAllByStudioCommandExecutionResultDTO(studioName, collectionManager.removeAllByStudioName(studioName));
    }
}
