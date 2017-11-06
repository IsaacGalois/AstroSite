package astroSite.services;

import astroSite.domain.NasaItem;

public interface NasaItemService {

    Iterable<NasaItem> listAllNasaItems();

    NasaItem getNasaItemById(Integer id);

    NasaItem saveNasaItem(NasaItem nasaItem);

    Iterable<NasaItem> saveNasaItemList(Iterable<NasaItem> nasaItemIterable);

    void deleteNasaItem(Integer id);
    
}
