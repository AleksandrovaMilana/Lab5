package server.commandexecutors.concrete;

import contract.dto.commanddto.CommandDTO;
import contract.dto.commanddto.concrete.UpdateCommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.UpdateCommandExecutionResultDTO;
import server.CollectionManager;
import server.business.Coordinates;
import server.business.MusicBand;
import server.business.MusicGenre;
import server.business.Studio;
import server.commandexecutors.CommandExecutor;

import java.time.LocalDate;

public class UpdateCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;

    public UpdateCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        UpdateCommandDTO updateCommandDTO = (UpdateCommandDTO) commandDTO;

        if (this.collectionManager.removeById(updateCommandDTO.getId()))
        {
            MusicBand musicBand = new MusicBand(
                    updateCommandDTO.getId(),
                    updateCommandDTO.getMusicBandName(),
                    new Coordinates(updateCommandDTO.getMusicBandCoordinatesX(),
                            updateCommandDTO.getMusicBandCoordinatesY()),
                    LocalDate.now(),
                    updateCommandDTO.getMusicBandNumberOfParticipants(),
                    updateCommandDTO.getMusicBandSinglesCount(),
                    MusicGenre.valueOf(updateCommandDTO.getMusicBandMusicGenre()),
                    new Studio(updateCommandDTO.getMusicBandStudioName())
            );
            return new UpdateCommandExecutionResultDTO(this.collectionManager.addMusicBandToTheCollection(musicBand), updateCommandDTO.getId());

        }
        else return new UpdateCommandExecutionResultDTO(false, updateCommandDTO.getId());

    }
}
