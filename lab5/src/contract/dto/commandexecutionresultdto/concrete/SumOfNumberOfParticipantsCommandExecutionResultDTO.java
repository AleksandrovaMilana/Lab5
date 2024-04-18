package contract.dto.commandexecutionresultdto.concrete;

import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public class SumOfNumberOfParticipantsCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public SumOfNumberOfParticipantsCommandExecutionResultDTO(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    int sum;

    @Override
    public String getCommandName() {
        return "sum_of_number_of_participants";
    }
}
