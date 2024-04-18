package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class CountByStudioCommandExecutionResultDTO implements CommandExecutionResultDTO {

    public CountByStudioCommandExecutionResultDTO(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    int count;

    @Override
    public String getCommandName() {
        return "count_by_studio";
    }
}
