package astroSite.services;

import astroSite.domain.NasaQueryRequest;

public interface NasaQueryRequestService {

    Iterable<NasaQueryRequest> listAllNasaQueryRequests();

    NasaQueryRequest getNasaQueryRequestById(Integer id);

    NasaQueryRequest saveNasaQueryRequest(NasaQueryRequest nasaQueryRequest);

    Iterable<NasaQueryRequest> saveNasaQueryRequestList(Iterable<NasaQueryRequest> nasaQueryRequestIterable);

    void deleteNasaQueryRequest(Integer id);

}
