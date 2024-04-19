package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class AddIfMaxCommandExecutionResultDTO implements CommandExecutionResultDTO {

    private String commandExecutionResultMessage;

    public AddIfMaxCommandExecutionResultDTO(String commandExecutionResultMessage){
        this.commandExecutionResultMessage = commandExecutionResultMessage;
    }
    @Override
    public String getCommandName() {
        return "add_if_max";
    }

    public String getCommandExecutionResultMessage() {
        return commandExecutionResultMessage;
    }
}
