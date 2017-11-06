package astroSite.services.impl;

import astroSite.domain.StrudelDec;
import astroSite.repositories.StrudelDecRepository;
import astroSite.services.StrudelDecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelDecServiceImpl implements StrudelDecService {

    @Autowired
    private StrudelDecRepository strudelDecRepository;

    @Override
    public Iterable<StrudelDec> listAllStrudelDecs() {
        return strudelDecRepository.findAll();
    }

    @Override
    public StrudelDec getStrudelDecById(Integer id) {
        return strudelDecRepository.findOne(id);
    }

    @Override
    public StrudelDec saveStrudelDec(StrudelDec strudelDec) {
        return strudelDecRepository.save(strudelDec);
    }

    @Override
    public Iterable<StrudelDec> saveStrudelDecList(Iterable<StrudelDec> strudelDecIterable) {
        return strudelDecRepository.save(strudelDecIterable);
    }

    @Override
    public void deleteStrudelDec(Integer id) {
        strudelDecRepository.delete(id);
    }
}
