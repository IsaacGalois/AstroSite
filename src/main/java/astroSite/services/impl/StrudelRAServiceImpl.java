package astroSite.services.impl;

import astroSite.domain.StrudelRA;
import astroSite.repositories.StrudelRARepository;
import astroSite.services.StrudelRAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelRAServiceImpl implements StrudelRAService{

    @Autowired
    private StrudelRARepository strudelRARepository;

    @Override
    public Iterable<StrudelRA> listAllStrudelRAs() {
        return strudelRARepository.findAll();
    }

    @Override
    public StrudelRA getStrudelRAById(Integer id) {
        return strudelRARepository.findOne(id);
    }

    @Override
    public StrudelRA saveStrudelRA(StrudelRA strudelRA) {
        return strudelRARepository.save(strudelRA);
    }

    @Override
    public Iterable<StrudelRA> saveStrudelRAList(Iterable<StrudelRA> strudelRAIterable) {
        return strudelRARepository.save(strudelRAIterable);
    }

    @Override
    public void deleteStrudelRA(Integer id) {
        strudelRARepository.delete(id);
    }
}
