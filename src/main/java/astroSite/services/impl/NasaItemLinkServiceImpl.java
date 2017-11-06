package astroSite.services.impl;

import astroSite.domain.NasaItemLink;
import astroSite.repositories.NasaItemLinkRepository;
import astroSite.services.NasaItemLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaItemLinkServiceImpl implements NasaItemLinkService{

    @Autowired
    private NasaItemLinkRepository nasaItemLinkRepository;

    @Override
    public Iterable<NasaItemLink> listAllNasaItemLink() {
        return nasaItemLinkRepository.findAll();
    }

    @Override
    public NasaItemLink getNasaItemLinkById(Integer id) {
        return nasaItemLinkRepository.findOne(id);
    }

    @Override
    public NasaItemLink saveNasaItemLink(NasaItemLink nasaData) {
        return nasaItemLinkRepository.save(nasaData);
    }

    @Override
    public Iterable<NasaItemLink> saveNasaItemLinkList(Iterable<NasaItemLink> nasaDataIterable) {
        return nasaItemLinkRepository.save(nasaDataIterable);
    }

    @Override
    public void deleteNasaItemLink(Integer id) {
        nasaItemLinkRepository.delete(id);
    }
}
