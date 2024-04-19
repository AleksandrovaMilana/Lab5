package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class RemoveAtCommandDTO implements CommandDTO {

    public int getIndex() {
        return index;
    }

    private int index;

    public RemoveAtCommandDTO(int index)
    {
       this.index = index;
    }

    @Override
    public String getCommandName() {
        return "remove_at";
    }
}
