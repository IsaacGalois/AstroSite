package astroSite.services;

import astroSite.domain.Filter;

public interface FilterService {

    Iterable<Filter> listAllFilters();

    Filter getFilterById(Integer id);

    Filter saveFilter(Filter filter);

    Iterable<Filter> saveFilterList(Iterable<Filter> filterIterable);

    void deleteFilter(Integer id);

}
