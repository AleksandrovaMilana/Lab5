package contract.dto.commandexecutionresultdto.concrete;

import contract.CommandIdentifier;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

import java.util.Map;

public class HelpCommandExecutionResultDTO implements CommandExecutionResultDTO {
    public HelpCommandExecutionResultDTO(Map<CommandIdentifier, String> helpMap) {
        this.helpMap = helpMap;
    }

    public Map<CommandIdentifier, String> getHelpMap() {
        return helpMap;
    }

    private final Map<CommandIdentifier, String> helpMap;

    @Override
    public String getCommandName() {
        return "help";
    }
}
