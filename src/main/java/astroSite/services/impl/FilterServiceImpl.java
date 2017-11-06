package astroSite.services.impl;

import astroSite.domain.Filter;
import astroSite.repositories.FilterRepository;
import astroSite.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService{

    @Autowired
    private FilterRepository filterRepository;

    @Override
    public Iterable<Filter> listAllFilters() {
        return filterRepository.findAll();
    }

    @Override
    public Filter getFilterById(Integer id) {
        return filterRepository.findOne(id);
    }

    @Override
    public Filter saveFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    @Override
    public Iterable<Filter> saveFilterList(Iterable<Filter> filterIterable) {
        return filterRepository.save(filterIterable);
    }

    @Override
    public void deleteFilter(Integer id) {
        filterRepository.delete(id);
    }
}
