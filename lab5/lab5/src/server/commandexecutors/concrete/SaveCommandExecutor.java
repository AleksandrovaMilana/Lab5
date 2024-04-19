package server.commandexecutors.concrete;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import contract.dto.commanddto.CommandDTO;
import contract.dto.commandexecutionresultdto.CommandExecutionResultDTO;
import contract.dto.commandexecutionresultdto.concrete.SaveCommandExecutionResultDTO;
import server.CollectionManager;
import server.util.LocalDateTypeAdapter;
import server.business.MusicBand;
import server.commandexecutors.CommandExecutor;

import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class SaveCommandExecutor implements CommandExecutor {

    final private CollectionManager collectionManager;

    public SaveCommandExecutor(CollectionManager collectionManager)
    {
        this.collectionManager = collectionManager;
    }


    @Override
    public CommandExecutionResultDTO execute(CommandDTO commandDTO) {
        List<MusicBand> musicBands = this.collectionManager.getCollectionCopy();

        String jsonOutput = "{    \"initDate\": \""
                +collectionManager.getCollectionInitializationDateTime() +
                "\",     \"collection\": [ ";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();

        for (MusicBand musicBand : musicBands)
            jsonOutput = jsonOutput.concat(gson.toJson(musicBand)).concat(", ");

        if (!musicBands.isEmpty())
            jsonOutput = jsonOutput.substring(0, jsonOutput.length() - 2);

        jsonOutput = jsonOutput.concat(" ] }");


        String result = "Коллекция успешно сохранена в файл";

        try {

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream(collectionManager.getCollectionFileName())
            );
            bufferedOutputStream.write(jsonOutput.getBytes());
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new SaveCommandExecutionResultDTO(result);

    }
}
