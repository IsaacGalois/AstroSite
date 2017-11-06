package astroSite.services.impl;

import astroSite.domain.NasaData;
import astroSite.repositories.NasaDataRepository;
import astroSite.services.NasaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaDataServiceImpl implements NasaDataService {

    @Autowired
    private NasaDataRepository nasaDataRepository;

    @Override
    public Iterable<NasaData> listAllNasaData() {
        return nasaDataRepository.findAll();
    }

    @Override
    public NasaData getNasaDataById(Integer id) {
        return nasaDataRepository.findOne(id);
    }

    @Override
    public NasaData saveNasaData(NasaData nasaData) {
        return nasaDataRepository.save(nasaData);
    }

    @Override
    public Iterable<NasaData> saveNasaDataList(Iterable<NasaData> nasaDataIterable) {
        return nasaDataRepository.save(nasaDataIterable);
    }

    @Override
    public void deleteNasaData(Integer id) {
        nasaDataRepository.delete(id);
    }
}
