package astroSite.services.impl;

import astroSite.domain.NasaCollection;
import astroSite.repositories.NasaCollectionRepository;
import astroSite.services.NasaCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaCollectionServiceImpl implements NasaCollectionService {

    @Autowired
    private NasaCollectionRepository nasaCollectionRepository;

    @Override
    public Iterable<NasaCollection> listAllNasaCollections() {
        return nasaCollectionRepository.findAll();
    }

    @Override
    public NasaCollection getNasaCollectionById(Integer id) {
        return nasaCollectionRepository.findOne(id);
    }

    @Override
    public NasaCollection saveNasaCollection(NasaCollection nasaCollection) {
        return nasaCollectionRepository.save(nasaCollection);
    }

    @Override
    public Iterable<NasaCollection> saveNasaCollectionList(Iterable<NasaCollection> nasaCollectionIterable) {
        return nasaCollectionRepository.save(nasaCollectionIterable);
    }

    @Override
    public void deleteNasaCollection(Integer id) {
        nasaCollectionRepository.delete(id);
    }

}
