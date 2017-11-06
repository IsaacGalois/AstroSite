package astroSite.controllers;

import astroSite.domain.*;
import astroSite.domain.VO.NasaQueryRequestVO;
import astroSite.services.NasaCollectionService;
import astroSite.services.NasaQueryRequestService;
import astroSite.services.NasaResponseService;
import astroSite.services.StrudelResponseService;
import astroSite.services.impl.NasaQueryRequestServiceImpl;
import astroSite.services.impl.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private NasaQueryRequestService nasaQueryRequestService;

    @Autowired
    private NasaCollectionService nasaCollectionService;

    @Autowired
    private NasaResponseService nasaResponseService;

    @Autowired
    private StrudelResponseService strudelResponseService;

    //Initial Index page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("nasaQueryRequestVO", new NasaQueryRequestVO());

        return "index";
    }

    //Login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //Result page for RestTemplate implementation
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(NasaQueryRequestVO nasaQueryRequestVO, Model model) {

        NasaQueryRequest nasaQueryRequest = saveNasaQueryRequestFromVO(nasaQueryRequestVO);

        NasaService nasaService = new NasaService();
//        NasaCollection nasaCollection = nasaService.makeNasaConnection(nasaQueryRequest);
//        NasaResponse nasaResponse = new NasaResponse(null,null,nasaCollection,nasaQueryRequest);

        NasaResponse nasaResponse = nasaService.makeNasaConnection(nasaQueryRequest);

        StrudelResponse strudelResponse = nasaService.makeStrudelConnection(nasaQueryRequest);


        //Save nasaCollection, nasaResponse, and strudelResponse to DB
//        nasaCollectionService.saveNasaCollection(nasaCollection);
        nasaResponseService.saveNasaResponse(nasaResponse);
        strudelResponseService.saveStrudelResponse(strudelResponse);

        model.addAttribute("itemList", nasaResponse.getNasaCollection().getNasaItemList());
        model.addAttribute("strudelResponse", strudelResponse);

        return "result";
    }

    //Result page for Ajax Implementation
    @RequestMapping(value= "/resultAjax/{naId}_{srId}", method = RequestMethod.GET)
    public String resultAjax(@PathVariable int naId, @PathVariable int srId, Model model) {
        NasaResponse nasaResponse = nasaResponseService.getNasaResponseById(naId);
        StrudelResponse strudelResponse = strudelResponseService.getStrudelResponseById(srId);
        strudelResponse.populateHasArray();

        model.addAttribute("itemList", nasaResponse.getNasaCollection().getNasaItemList());
        model.addAttribute("strudelResponse", strudelResponse);

        return "result";
    }

    //Helper Methods
    public NasaQueryRequest saveNasaQueryRequestFromVO(NasaQueryRequestVO nasaQueryRequestVO) {

        List<Filter> filterList = new ArrayList<>();
        Filter aFilter;

        nasaQueryRequestVO.makeFilterList();

        for(List<String> f: nasaQueryRequestVO.getFilterList()) {
            if(!f.get(1).equals("")) {
                aFilter = new Filter(f.get(0),f.get(1));
                filterList.add(aFilter);
            }
        }

        NasaQueryRequest nasaQueryRequest = new NasaQueryRequest(filterList);
        nasaQueryRequestService.saveNasaQueryRequest(nasaQueryRequest);

        return nasaQueryRequest;
    }
}
