package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.AddCommandDTO;
import contract.dto.commanddto.concrete.AddIfMaxCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.AddCommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.AddIfMaxCommandExecutionResultDTO;
import server.CollectionManager;
import server.business.Coordinates;
import server.business.MusicBand;
import server.business.MusicGenre;
import server.business.Studio;
import server.commandexecutors.CommandExecutor;

import java.time.LocalDate;

public class AddIfMaxCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;

    public AddIfMaxCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        AddIfMaxCommandDTO addIfMaxCommandDTO = (AddIfMaxCommandDTO) commandDTO;



        MusicBand musicBand = new MusicBand(
                this.collectionManager.generateId(),
                addIfMaxCommandDTO.getMusicBandName(),
                new Coordinates(addIfMaxCommandDTO.getMusicBandCoordinatesX(),
                        addIfMaxCommandDTO.getMusicBandCoordinatesY()),
                LocalDate.now(),
                addIfMaxCommandDTO.getMusicBandNumberOfParticipants(),
                addIfMaxCommandDTO.getMusicBandSinglesCount(),
                MusicGenre.valueOf(addIfMaxCommandDTO.getMusicBandMusicGenre()),
                new Studio(addIfMaxCommandDTO.getMusicBandStudioName())
        );

        String commandExecutionResultMessage;

        if (musicBand.compareTo(collectionManager.maxMusicBand()) > 0)
        {
            boolean flag = this.collectionManager.addMusicBandToTheCollection(musicBand);

            if (flag)
                commandExecutionResultMessage = "Музыкальная группа успешно добавлена в коллекцию";
            else
                commandExecutionResultMessage = "Музыкальная группа не добавлена в коллекцию";
            return new AddIfMaxCommandExecutionResultDTO(commandExecutionResultMessage);
        }
        else
        {
            commandExecutionResultMessage = "Музыкальная группа не добавлена в коллекцию, потому что она не наибольшая";
            return new AddIfMaxCommandExecutionResultDTO(commandExecutionResultMessage);
        }

    }
}
