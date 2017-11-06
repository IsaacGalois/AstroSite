package astroSite.services;

import astroSite.domain.NasaCollectionMetadata;

public interface NasaCollectionMetadataService {

    Iterable<NasaCollectionMetadata> listAllNasaCollectionMetadatas();

    NasaCollectionMetadata getNasaCollectionMetadataById(Integer id);

    NasaCollectionMetadata saveNasaCollectionMetadata(NasaCollectionMetadata nasaCollectionMetadata);

    Iterable<NasaCollectionMetadata> saveNasaCollectionMetadataList(Iterable<NasaCollectionMetadata> nasaCollectionMetadataIterable);

    void deleteNasaCollectionMetadata(Integer id);
}
