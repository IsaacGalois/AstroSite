package astroSite.services.impl;

import astroSite.domain.NasaResponse;
import astroSite.repositories.NasaResponseRepository;
import astroSite.services.NasaResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaResponseServiceImpl implements NasaResponseService {

    @Autowired
    private NasaResponseRepository nasaResponseRepository;

    @Override
    public Iterable<NasaResponse> listAllNasaResponses() {
        return nasaResponseRepository.findAll();
    }

    @Override
    public NasaResponse getNasaResponseById(Integer id) {
        return nasaResponseRepository.findOne(id);
    }

    @Override
    public NasaResponse saveNasaResponse(NasaResponse nasaResponse) {
        return nasaResponseRepository.save(nasaResponse);
    }

    @Override
    public Iterable<NasaResponse> saveNasaResponseList(Iterable<NasaResponse> nasaResponseIterable) {
        return nasaResponseRepository.save(nasaResponseIterable);
    }

    @Override
    public void deleteNasaResponse(Integer id) {
        nasaResponseRepository.delete(id);
    }
}
