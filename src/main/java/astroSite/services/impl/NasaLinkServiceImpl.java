package astroSite.services.impl;

import astroSite.domain.NasaLink;
import astroSite.repositories.NasaLinkRepository;
import astroSite.services.NasaLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaLinkServiceImpl implements NasaLinkService{

    @Autowired
    private NasaLinkRepository nasaLinkRepository;

    @Override
    public Iterable<NasaLink> listAllNasaLinks() {
        return nasaLinkRepository.findAll();
    }

    @Override
    public NasaLink getNasaLinkById(Integer id) {
        return nasaLinkRepository.findOne(id);
    }

    @Override
    public NasaLink saveNasaLink(NasaLink nasaLink) {
        return nasaLinkRepository.save(nasaLink);
    }

    @Override
    public Iterable<NasaLink> saveNasaLinkList(Iterable<NasaLink> nasaLinkIterable) {
        return nasaLinkRepository.save(nasaLinkIterable);
    }

    @Override
    public void deleteNasaLink(Integer id) {
        nasaLinkRepository.delete(id);
    }

}
