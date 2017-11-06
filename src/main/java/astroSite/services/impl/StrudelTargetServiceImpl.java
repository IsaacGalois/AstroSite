package astroSite.services.impl;

import astroSite.domain.StrudelTarget;
import astroSite.repositories.StrudelTargetRepository;
import astroSite.services.StrudelTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelTargetServiceImpl implements StrudelTargetService{

    @Autowired
    private StrudelTargetRepository strudelTargetRepository;

    @Override
    public Iterable<StrudelTarget> listAllStrudelTargets() {
        return strudelTargetRepository.findAll();
    }

    @Override
    public StrudelTarget getStrudelTargetById(Integer id) {
        return strudelTargetRepository.findOne(id);
    }

    @Override
    public StrudelTarget saveStrudelTarget(StrudelTarget strudelTarget) {
        return strudelTargetRepository.save(strudelTarget);
    }

    @Override
    public Iterable<StrudelTarget> saveStrudelTargetList(Iterable<StrudelTarget> strudelTargetIterable) {
        return strudelTargetRepository.save(strudelTargetIterable);
    }

    @Override
    public void deleteStrudelTarget(Integer id) {
        strudelTargetRepository.delete(id);
    }
}
