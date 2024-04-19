package contract.dto.commanddto.concrete;

import contract.dto.commanddto.CommandDTO;

public class CountByStudioCommandDTO implements CommandDTO {
    @Override
    public String getCommandName() {
        return "count_by_studio";
    }

    public CountByStudioCommandDTO(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioName() {
        return studioName;
    }

    private String studioName;

}
