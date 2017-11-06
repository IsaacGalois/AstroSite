package astroSite.services.impl;

import astroSite.domain.NasaItem;
import astroSite.repositories.NasaItemRepository;
import astroSite.services.NasaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaItemServiceImpl implements NasaItemService {

    @Autowired
    private NasaItemRepository nasaItemRepository;

    @Override
    public Iterable<NasaItem> listAllNasaItems() {
        return nasaItemRepository.findAll();
    }

    @Override
    public NasaItem getNasaItemById(Integer id) {
        return nasaItemRepository.findOne(id);
    }

    @Override
    public NasaItem saveNasaItem(NasaItem nasaItem) {
        return nasaItemRepository.save(nasaItem);
    }

    @Override
    public Iterable<NasaItem> saveNasaItemList(Iterable<NasaItem> nasaItemIterable) {
        return nasaItemRepository.save(nasaItemIterable);
    }

    @Override
    public void deleteNasaItem(Integer id) {
        nasaItemRepository.delete(id);
    }
}
