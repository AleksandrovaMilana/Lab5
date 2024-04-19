package client.commandExecutionResultHandlers;

import client.exeptions.ExitException;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;

public interface CommandExecutionResultHandler {
    String handleServerResponse(CommandExecutionResultDTO commandExecutionResultDTO) throws ExitException;
}
