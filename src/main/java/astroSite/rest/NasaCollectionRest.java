package astroSite.rest;

import astroSite.domain.NasaCollection;
import astroSite.services.NasaCollectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasaCollection")
public class NasaCollectionRest {

    private Logger log = Logger.getLogger(NasaCollectionRest.class);

    @Autowired
    private NasaCollectionService nasaCollectionService;

    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<NasaCollection> getAll() {
        return nasaCollectionService.listAllNasaCollections();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NasaCollection getById(@PathVariable int id) {
        return nasaCollectionService.getNasaCollectionById(id);
    }

    //SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public NasaCollection save(@RequestBody NasaCollection nasaCollection) {
        return nasaCollectionService.saveNasaCollection(nasaCollection);
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            nasaCollectionService.deleteNasaCollection(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }
}
