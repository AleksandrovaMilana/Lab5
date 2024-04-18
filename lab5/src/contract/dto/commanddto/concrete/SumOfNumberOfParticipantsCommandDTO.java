package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class SumOfNumberOfParticipantsCommandDTO implements CommandDTO {
    @Override
    public String getCommandName() {
        return "sum_of_number_of_participants";
    }
}
