package astroSite.bootstrap;

import astroSite.domain.Filter;
import astroSite.domain.NasaQueryRequest;
import astroSite.services.NasaQueryRequestService;
import astroSite.services.impl.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private NasaQueryRequestService nasaQueryRequestService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        generateNasaQueryRequests();

//        HashMap<String,String> map = new HashMap<>();
//        map.put(NasaQueryRequest.filterTypes[0],"Moon Landing");
//        map.put(NasaQueryRequest.filterTypes[3],"Buzz Aldrin,Neil Armstrong");
//        map.put(NasaQueryRequest.filterTypes[9],"1968");
//        map.put(NasaQueryRequest.filterTypes[10],"1977");
//
//
//        NasaQueryRequest x = new NasaQueryRequest(map);
//        x.makeRequestUrl();

    }

    private void generateNasaQueryRequests() {

        List<NasaQueryRequest> nqrList = new ArrayList<>();

        Filter filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Mercury");
        Filter filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list1 = new ArrayList<>();
        list1.add(filter1);
        list1.add(filter2);
        nqrList.add(new NasaQueryRequest(list1));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Venus");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list2 = new ArrayList<>();
        list2.add(filter1);
        list2.add(filter2);
        nqrList.add(new NasaQueryRequest(list2));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Earth");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list3 = new ArrayList<>();
        list3.add(filter1);
        list3.add(filter2);
        nqrList.add(new NasaQueryRequest(list3));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Mars");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list4 = new ArrayList<>();
        list4.add(filter1);
        list4.add(filter2);
        nqrList.add(new NasaQueryRequest(list4));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Jupiter");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list5 = new ArrayList<>();
        list5.add(filter1);
        list5.add(filter2);
        nqrList.add(new NasaQueryRequest(list5));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Saturn");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list6 = new ArrayList<>();
        list6.add(filter1);
        list6.add(filter2);
        nqrList.add(new NasaQueryRequest(list6));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Uranus");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list7 = new ArrayList<>();
        list7.add(filter1);
        list7.add(filter2);
        nqrList.add(new NasaQueryRequest(list7));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Neptune");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list8 = new ArrayList<>();
        list8.add(filter1);
        list8.add(filter2);
        nqrList.add(new NasaQueryRequest(list8));

        filter1 = new Filter(NasaQueryRequest.filterTypes[0],"Sun");
        filter2 = new Filter(NasaQueryRequest.filterTypes[5],"image");
        List<Filter> list9 = new ArrayList<>();
        list9.add(filter1);
        list9.add(filter2);
        nqrList.add(new NasaQueryRequest(list9));

        nasaQueryRequestService.saveNasaQueryRequestList(nqrList);

    }
}
