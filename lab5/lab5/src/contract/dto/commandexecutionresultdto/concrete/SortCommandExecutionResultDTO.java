package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class SortCommandExecutionResultDTO implements CommandExecutionResultDTO {

    private String commandExecutionResultMessage;

    public SortCommandExecutionResultDTO(String commandExecutionResultMessage){
        this.commandExecutionResultMessage = commandExecutionResultMessage;
    }
    @Override
    public String getCommandName() {
        return "sort";
    }

    public String getCommandExecutionResultMessage() {
        return commandExecutionResultMessage;
    }
}
