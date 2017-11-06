package astroSite.services;

import astroSite.domain.NasaResponse;

public interface NasaResponseService {

    Iterable<NasaResponse> listAllNasaResponses();

    NasaResponse getNasaResponseById(Integer id);

    NasaResponse saveNasaResponse(NasaResponse nasaResponse);

    Iterable<NasaResponse> saveNasaResponseList(Iterable<NasaResponse> nasaResponseIterable);

    void deleteNasaResponse(Integer id);
}
