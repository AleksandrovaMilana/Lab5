package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class RemoveAllByStudioCommandDTO implements CommandDTO {
    public RemoveAllByStudioCommandDTO(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioName() {
        return studioName;
    }

    private String studioName;
    @Override
    public String getCommandName() {
        return "remove_all_by_studio";
    }
}
