package server;

import server.business.MusicBand;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

public class CollectionManager {

    private List<MusicBand> musicBands;
    private ZonedDateTime collectionInitializationDateTime;

    public CollectionManager(List<MusicBand> list)
    {
        this.musicBands = list;
        this.collectionInitializationDateTime = ZonedDateTime.now();
    }

    public boolean addMusicBandToTheCollection(MusicBand musicBand)
    {
        return this.musicBands.add(musicBand);
    }

    private long maxIdOfTheCollection()
    {
       return this.musicBands.stream().max(new Comparator<MusicBand>() {
            @Override
            public int compare(MusicBand o1, MusicBand o2) {
                return Math.toIntExact(o2.getId() - o1.getId());
            }
        }).get().getId();
    }

    public long generateId()
    {
        if (this.musicBands.isEmpty())
            return 1L;
        return this.maxIdOfTheCollection() + 1;
    }

    public String getTypeOfCollection()
    {
        return musicBands.getClass().getSimpleName();
    }


    public ZonedDateTime getCollectionInitializationDateTime() {
        return collectionInitializationDateTime;
    }

    public int getSizeOfTheCollection()
    {
        return this.musicBands.size();
    }
}
