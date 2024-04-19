package server;

import server.business.MusicBand;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CollectionManager {

    public String getCollectionFileName() {
        return collectionFileName;
    }

    public void setCollectionFileName(String collectionFileName) {
        this.collectionFileName = collectionFileName;
    }

    private String collectionFileName;
    private LocalDate collectionInitializationDateTime;
    private List<MusicBand> musicBands;


    public CollectionManager(List<MusicBand> set,
                             LocalDate collectionInitializationDateTime,
                             String collectionFileName)
    {
        this.musicBands = set;
        this.collectionInitializationDateTime = collectionInitializationDateTime;
        this.collectionFileName = collectionFileName;
    }

    public boolean addMusicBandToTheCollection(MusicBand musicBand)
    {
        return this.musicBands.add(musicBand);
    }

    public int sumOOfNumberOfParticipants()
    {
        int sum = 0;
        for (MusicBand musicBand : musicBands)
            sum += musicBand.getNumberOfParticipants();
        return sum;
    }

    public int countByStudio(String studioName)
    {
        int count = 0;
        for (MusicBand musicBand : musicBands)
            if (musicBand.getStudio().getName().equals(studioName))
                count ++;
        return count;
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

    public List<MusicBand> getCollectionCopy()
    {
        return new LinkedList<>(this.musicBands);
    }

    public void clear()
    {
        this.musicBands.clear();
    }

    public LocalDate getCollectionInitializationDateTime() {
        return collectionInitializationDateTime;
    }

    public int getSizeOfTheCollection()
    {
        return this.musicBands.size();
    }

    public void sort()
    {
        musicBands.sort(new Comparator<MusicBand>() {
            @Override
            public int compare(MusicBand o1, MusicBand o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public MusicBand maxMusicBand()
    {
        if (musicBands.isEmpty())
                return null;
            return musicBands.stream().max(new Comparator<MusicBand>() {
            @Override
            public int compare(MusicBand o1, MusicBand o2) {
                return o1.compareTo(o2);
            }
        }).get();

    }

    public boolean  removeById(long id){
        return this.musicBands.removeIf(musicBand -> (musicBand.getId() == id));
    }

    public boolean  removeAllByStudioName(String studioName){
        return this.musicBands.removeIf(musicBand -> (musicBand.getStudio().getName().equals(studioName)));
    }

    public void   removeByIndex(int index){
        this.musicBands.remove(index);
    }
}
