package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class RemoveByIdCommandDTO implements CommandDTO {

    private long id;

    public RemoveByIdCommandDTO(long id)
    {
        this.id = id;
    }

    @Override
    public String getCommandName() {
        return "remove_by_id";
    }

    public long getId() {
        return id;
    }

}
