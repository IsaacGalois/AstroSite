package astroSite.services.impl;

import astroSite.domain.StrudelServOb;
import astroSite.repositories.StrudelServObRepository;
import astroSite.services.StrudelServObService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelServObServiceImpl implements StrudelServObService{

    @Autowired
    StrudelServObRepository strudelServObRepository;

    @Override
    public Iterable<StrudelServOb> listAllStrudelServObs() {
        return strudelServObRepository.findAll();
    }

    @Override
    public StrudelServOb getStrudelServObById(Integer id) {
        return strudelServObRepository.findOne(id);
    }

    @Override
    public StrudelServOb saveStrudelServOb(StrudelServOb strudelServOb) {
        return strudelServObRepository.save(strudelServOb);
    }

    @Override
    public Iterable<StrudelServOb> saveStrudelServObList(Iterable<StrudelServOb> strudelServObIterable) {
        return strudelServObRepository.save(strudelServObIterable);
    }

    @Override
    public void deleteStrudelServOb(Integer id) {
        strudelServObRepository.delete(id);
    }
}
