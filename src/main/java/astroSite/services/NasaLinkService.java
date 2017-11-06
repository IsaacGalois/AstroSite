package astroSite.services;

import astroSite.domain.NasaLink;

public interface NasaLinkService {

    Iterable<NasaLink> listAllNasaLinks();

    NasaLink getNasaLinkById(Integer id);

    NasaLink saveNasaLink(NasaLink nasaLink);

    Iterable<NasaLink> saveNasaLinkList(Iterable<NasaLink> nasaLinkIterable);

    void deleteNasaLink(Integer id);
    
}
