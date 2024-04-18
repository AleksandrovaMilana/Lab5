package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class RemoveAllByStudioCommandExecutionResultDTO implements CommandExecutionResultDTO {

    public String getStudioName() {
        return studioName;
    }

    private String studioName;

    public boolean isMusicBandRemovedByCommandExecution() {
        return musicBandRemovedByCommandExecution;
    }

    private boolean musicBandRemovedByCommandExecution;

    public RemoveAllByStudioCommandExecutionResultDTO(String studioName, boolean commandExecutionResult){
        this.musicBandRemovedByCommandExecution = commandExecutionResult;
        this.studioName = studioName;
    }

    @Override
    public String getCommandName() {
        return "remove_all_by_studio";
    }
}
