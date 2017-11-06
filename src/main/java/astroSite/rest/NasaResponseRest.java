package astroSite.rest;

import astroSite.domain.NasaResponse;
import astroSite.services.NasaResponseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasaResponse")
public class NasaResponseRest {

    private Logger log = Logger.getLogger(NasaResponseRest.class);

    @Autowired
    private NasaResponseService nasaResponseService;

    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<NasaResponse> getAll() {
        return nasaResponseService.listAllNasaResponses();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NasaResponse getById(@PathVariable int id) {
        return nasaResponseService.getNasaResponseById(id);
    }

    //SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public NasaResponse save(@RequestBody NasaResponse nasaResponse) {
        return nasaResponseService.saveNasaResponse(nasaResponse);
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            nasaResponseService.deleteNasaResponse(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }
}
