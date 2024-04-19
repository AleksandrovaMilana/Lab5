package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class SortCommandDTO implements CommandDTO {
    @Override
    public String getCommandName() {
        return "sort";
    }
}
