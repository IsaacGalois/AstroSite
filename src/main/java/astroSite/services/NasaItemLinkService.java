package astroSite.services;

import astroSite.domain.NasaItemLink;

public interface NasaItemLinkService {

    Iterable<NasaItemLink> listAllNasaItemLink();

    NasaItemLink getNasaItemLinkById(Integer id);

    NasaItemLink saveNasaItemLink(NasaItemLink nasaData);

    Iterable<NasaItemLink> saveNasaItemLinkList(Iterable<NasaItemLink> nasaDataIterable);

    void deleteNasaItemLink(Integer id);
}
