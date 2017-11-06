package astroSite.services.impl;

import astroSite.domain.NasaMetadata;
import astroSite.repositories.NasaMetadataRepository;
import astroSite.services.NasaMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaMetadataServiceImpl implements NasaMetadataService {

    @Autowired
    private NasaMetadataRepository nasaMetadataRepository;

    @Override
    public Iterable<NasaMetadata> listAllNasaMetadatas() {
        return nasaMetadataRepository.findAll();
    }

    @Override
    public NasaMetadata getNasaMetadataById(Integer id) {
        return nasaMetadataRepository.findOne(id);
    }

    @Override
    public NasaMetadata saveNasaMetadata(NasaMetadata nasaMetadata) {
        return nasaMetadataRepository.save(nasaMetadata);
    }

    @Override
    public Iterable<NasaMetadata> saveNasaMetadataList(Iterable<NasaMetadata> nasaMetadataIterable) {
        return nasaMetadataRepository.save(nasaMetadataIterable);
    }

    @Override
    public void deleteNasaMetadata(Integer id) {
        nasaMetadataRepository.delete(id);
    }
}
