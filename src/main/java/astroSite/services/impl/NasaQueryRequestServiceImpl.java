package astroSite.services.impl;

import astroSite.domain.NasaQueryRequest;
import astroSite.repositories.NasaQueryRequestRepository;
import astroSite.services.NasaQueryRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaQueryRequestServiceImpl implements NasaQueryRequestService{

    @Autowired
    private NasaQueryRequestRepository nasaQueryRequestRepository;

    @Override
    public Iterable<NasaQueryRequest> listAllNasaQueryRequests() {
        return nasaQueryRequestRepository.findAll();
    }

    @Override
    public NasaQueryRequest getNasaQueryRequestById(Integer id) {
        return nasaQueryRequestRepository.findOne(id);
    }

    @Override
    public NasaQueryRequest saveNasaQueryRequest(NasaQueryRequest nasaQueryRequest) {
        return nasaQueryRequestRepository.save(nasaQueryRequest);
    }

    @Override
    public Iterable<NasaQueryRequest> saveNasaQueryRequestList(Iterable<NasaQueryRequest> nasaQueryRequestIterable) {
        return nasaQueryRequestRepository.save(nasaQueryRequestIterable);
    }

    @Override
    public void deleteNasaQueryRequest(Integer id) {
        nasaQueryRequestRepository.delete(id);
    }
}
