package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class RemoveAtCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public RemoveAtCommandExecutionResultDTO(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    private int index;

    @Override
    public String getCommandName() {
        return "remove_at";
    }
}
