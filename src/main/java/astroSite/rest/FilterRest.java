package astroSite.rest;

import astroSite.domain.Filter;
import astroSite.services.FilterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filter")
public class FilterRest {


    private Logger log = Logger.getLogger(FilterRest.class);

    @Autowired
    private FilterService filterService;

    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Filter> getAll() {
        return filterService.listAllFilters();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Filter getById(@PathVariable int id) {
        return filterService.getFilterById(id);
    }

    //SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Filter save(@RequestBody Filter filter) {
        return filterService.saveFilter(filter);
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            filterService.deleteFilter(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }


}
