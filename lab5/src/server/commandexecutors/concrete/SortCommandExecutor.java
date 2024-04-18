package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.SortCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.ClearCommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SortCommandExecutionResultDTO;
import server.CollectionManager;
import server.commandexecutors.CommandExecutor;

public class SortCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;
    public SortCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        collectionManager.sort();

        return new SortCommandExecutionResultDTO("Коллекция отсортирована");
    }
}
