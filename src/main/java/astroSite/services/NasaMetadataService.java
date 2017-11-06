package astroSite.services;

import astroSite.domain.NasaMetadata;

public interface NasaMetadataService {

    Iterable<NasaMetadata> listAllNasaMetadatas();

    NasaMetadata getNasaMetadataById(Integer id);

    NasaMetadata saveNasaMetadata(NasaMetadata nasaMetadata);

    Iterable<NasaMetadata> saveNasaMetadataList(Iterable<NasaMetadata> nasaMetadataIterable);

    void deleteNasaMetadata(Integer id);
    
}
