package astroSite.services.impl;

import astroSite.domain.StrudelGalactic;
import astroSite.repositories.StrudelGalacticRepository;
import astroSite.services.StrudelGalacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelGalacticServiceImpl implements StrudelGalacticService {

    @Autowired
    private StrudelGalacticRepository strudelGalacticRepository;

    @Override
    public Iterable<StrudelGalactic> listAllStrudelGalactics() {
        return strudelGalacticRepository.findAll();
    }

    @Override
    public StrudelGalactic getStrudelGalacticById(Integer id) {
        return strudelGalacticRepository.findOne(id);
    }

    @Override
    public StrudelGalactic saveStrudelGalactic(StrudelGalactic strudelGalactic) {
        return strudelGalacticRepository.save(strudelGalactic);
    }

    @Override
    public Iterable<StrudelGalactic> saveStrudelGalacticList(Iterable<StrudelGalactic> strudelGalacticIterable) {
        return strudelGalacticRepository.save(strudelGalacticIterable);
    }

    @Override
    public void deleteStrudelGalactic(Integer id) {
        strudelGalacticRepository.delete(id);
    }
}
