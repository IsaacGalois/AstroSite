package astroSite.services;

import astroSite.domain.NasaData;

public interface NasaDataService {

    Iterable<NasaData> listAllNasaData();

    NasaData getNasaDataById(Integer id);

    NasaData saveNasaData(NasaData nasaData);

    Iterable<NasaData> saveNasaDataList(Iterable<NasaData> nasaDataIterable);

    void deleteNasaData(Integer id);

}
