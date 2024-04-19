package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class RemoveByIdCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public long getId() {
        return id;
    }

    private long id;

    public boolean isMusicBandRemovedByCommandExecution() {
        return musicBandRemovedByCommandExecution;
    }

    private boolean musicBandRemovedByCommandExecution;

    public RemoveByIdCommandExecutionResultDTO(long id, boolean commandExecutionResult){
        this.musicBandRemovedByCommandExecution = commandExecutionResult;
        this.id = id;
    }

    @Override
    public String getCommandName() {
        return "remove_by_id";
    }
}
