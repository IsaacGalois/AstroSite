package astroSite.services.impl;

import astroSite.domain.StrudelResponse;
import astroSite.repositories.StrudelResponseRepository;
import astroSite.services.StrudelResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrudelResponseServiceImpl implements StrudelResponseService {

    @Autowired
    private StrudelResponseRepository strudelResponseRepository;

    @Override
    public Iterable<StrudelResponse> listAllStrudelResponses() {
        return strudelResponseRepository.findAll();
    }

    @Override
    public StrudelResponse getStrudelResponseById(Integer id) {
        return strudelResponseRepository.findOne(id);
    }

    @Override
    public StrudelResponse saveStrudelResponse(StrudelResponse strudelResponse) {
        return strudelResponseRepository.save(strudelResponse);
    }

    @Override
    public Iterable<StrudelResponse> saveStrudelResponseList(Iterable<StrudelResponse> strudelResponseIterable) {
        return strudelResponseRepository.save(strudelResponseIterable);
    }

    @Override
    public void deleteStrudelResponse(Integer id) {
        strudelResponseRepository.delete(id);
    }
}
