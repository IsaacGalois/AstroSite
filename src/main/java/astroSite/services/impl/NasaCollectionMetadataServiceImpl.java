package astroSite.services.impl;

import astroSite.domain.NasaCollectionMetadata;
import astroSite.repositories.NasaCollectionMetadataRepository;
import astroSite.services.NasaCollectionMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaCollectionMetadataServiceImpl implements NasaCollectionMetadataService{

    @Autowired
    private NasaCollectionMetadataRepository nasaCollectionMetadataRepository;

    @Override
    public Iterable<NasaCollectionMetadata> listAllNasaCollectionMetadatas() {
        return nasaCollectionMetadataRepository.findAll();
    }

    @Override
    public NasaCollectionMetadata getNasaCollectionMetadataById(Integer id) {
        return nasaCollectionMetadataRepository.findOne(id);
    }

    @Override
    public NasaCollectionMetadata saveNasaCollectionMetadata(NasaCollectionMetadata nasaCollectionMetadata) {
        return nasaCollectionMetadataRepository.save(nasaCollectionMetadata);
    }

    @Override
    public Iterable<NasaCollectionMetadata> saveNasaCollectionMetadataList(Iterable<NasaCollectionMetadata> nasaCollectionMetadataIterable) {
        return nasaCollectionMetadataRepository.save(nasaCollectionMetadataIterable);
    }

    @Override
    public void deleteNasaCollectionMetadata(Integer id) {
        nasaCollectionMetadataRepository.delete(id);
    }
}
