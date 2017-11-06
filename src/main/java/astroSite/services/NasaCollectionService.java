package astroSite.services;

import astroSite.domain.NasaCollection;

public interface NasaCollectionService {

    Iterable<NasaCollection> listAllNasaCollections();

    NasaCollection getNasaCollectionById(Integer id);

    NasaCollection saveNasaCollection(NasaCollection nasaCollection);

    Iterable<NasaCollection> saveNasaCollectionList(Iterable<NasaCollection> nasaCollectionIterable);

    void deleteNasaCollection(Integer id);
}
