package astroSite.rest;

import astroSite.domain.NasaQueryRequest;
import astroSite.services.NasaQueryRequestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasaQueryRequest")
public class NasaQueryRequestRest {
    
    private Logger log = Logger.getLogger(NasaQueryRequestRest.class);
    
    @Autowired
    private NasaQueryRequestService nasaQueryRequestService;
    
    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<NasaQueryRequest> getAll() {
        return nasaQueryRequestService.listAllNasaQueryRequests();
    }
    
    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NasaQueryRequest getById(@PathVariable int id) {
        return nasaQueryRequestService.getNasaQueryRequestById(id);
    }

    //SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public NasaQueryRequest save(@RequestBody NasaQueryRequest nasaQueryRequest) {
        return nasaQueryRequestService.saveNasaQueryRequest(nasaQueryRequest);
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            nasaQueryRequestService.deleteNasaQueryRequest(id);
            result = true;
        } catch(Exception ex) {
            log.info(ex);
        }
        return result;
    }
    
    
}
