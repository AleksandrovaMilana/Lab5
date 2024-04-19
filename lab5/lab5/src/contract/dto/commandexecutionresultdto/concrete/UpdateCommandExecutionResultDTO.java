package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class UpdateCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public long getId() {
        return id;
    }

    private long id;

    public boolean isMusicBandRemovedByCommandExecution() {
        return musicBandRemovedByCommandExecution;
    }

    private boolean musicBandRemovedByCommandExecution;

    public UpdateCommandExecutionResultDTO(boolean commandExecutionResult, long id){
        this.musicBandRemovedByCommandExecution = commandExecutionResult;
        this.id = id;
    }

    @Override
    public String getCommandName() {
        return "update";
    }
}
