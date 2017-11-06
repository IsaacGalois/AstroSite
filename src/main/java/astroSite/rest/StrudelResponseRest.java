package astroSite.rest;

import astroSite.domain.StrudelResponse;
import astroSite.services.StrudelResponseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/strudelResponse")
public class StrudelResponseRest {

    private Logger log = Logger.getLogger(StrudelResponseRest.class);

    @Autowired
    private StrudelResponseService strudelResponseService;

    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<StrudelResponse> getAll() {
        return strudelResponseService.listAllStrudelResponses();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StrudelResponse getById(@PathVariable int id) {
        return strudelResponseService.getStrudelResponseById(id);
    }

    //SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public StrudelResponse save(@RequestBody StrudelResponse strudelResponse) {
        return strudelResponseService.saveStrudelResponse(strudelResponse);
    }

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            strudelResponseService.deleteStrudelResponse(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }
}
