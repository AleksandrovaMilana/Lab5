package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import server.business.MusicBand;

import java.util.List;

public class ShowCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public ShowCommandExecutionResultDTO(List<String> collectionElements) {
        this.collectionElements = collectionElements;
    }

    public List<String> getCollectionElements() {
        return collectionElements;
    }

    private final List<String> collectionElements;
    @Override
    public String getCommandName() {
        return "show";
    }
}
