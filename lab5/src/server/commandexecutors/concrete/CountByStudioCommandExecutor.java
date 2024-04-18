package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.CountByStudioCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.CountByStudioCommandExecutionResultDTO;
import server.CollectionManager;
import server.commandexecutors.CommandExecutor;

public class CountByStudioCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;
    public CountByStudioCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        CountByStudioCommandDTO countByStudioCommandDTO = (CountByStudioCommandDTO) commandDTO;


        return new CountByStudioCommandExecutionResultDTO(collectionManager.countByStudio(countByStudioCommandDTO.getStudioName()));
    }
}
