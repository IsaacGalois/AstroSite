package astroSite.services.impl;

import astroSite.domain.*;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class NasaService {

    RestTemplate restTemplate;

//    public NasaCollection makeNasaConnection(NasaQueryRequest nasaQueryRequest) {
//        restTemplate = new RestTemplate();
//        NasaCollection nasaCollection = null;
//
//        try {
//            String nasaUrl = nasaQueryRequest.makeRequestUrl();
//
////            System.out.println("nasaUrl: "+nasaUrl);
//
//            ResponseEntity<String> response = restTemplate.getForEntity(nasaUrl,String.class);
//            String jsonString = response.getBody();
//
////            System.out.println("JSON String: "+jsonString);
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonFactory factory = mapper.getFactory();
//            JsonParser parser = factory.createParser(jsonString);
//            JsonNode root = mapper.readTree(parser);
//            nasaCollection = mapper.treeToValue(root.get("collection"),NasaCollection.class);
//            nasaCollection.setNasaQueryRequest(nasaQueryRequest);
//
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return nasaCollection;
//    }

    public NasaResponse makeNasaConnection(NasaQueryRequest nasaQueryRequest) {
        restTemplate = new RestTemplate();
        NasaResponse nasaResponse = null;

        try {
            String nasaUrl = nasaQueryRequest.makeRequestUrl();

//            System.out.println("nasaUrl: "+nasaUrl);

            ResponseEntity<String> response = restTemplate.getForEntity(nasaUrl,String.class);
            String jsonString = response.getBody();

//            System.out.println("JSON String: "+jsonString);

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(jsonString);
            JsonNode root = mapper.readTree(parser);
            nasaResponse = mapper.treeToValue(root,NasaResponse.class);
            nasaResponse.setNasaQueryRequest(nasaQueryRequest);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return nasaResponse;
    }

    public StrudelResponse makeStrudelConnection(NasaQueryRequest nasaQueryRequest) {
        restTemplate = new RestTemplate();
        StrudelResponse strudelResponse = null;

        try {
            String strudelContent = "";
            List<Filter> filterList = nasaQueryRequest.getFilterList();
            for(Filter filter: filterList) {
                if(filter.getFilterName().equals("q"))
                    strudelContent = filter.getFilterContent();
            }
            String strudelUrl = "http://www.strudel.org.uk/lookUP/json/?name="+strudelContent;

//            System.out.println("strudelUrl: "+strudelUrl);

            ResponseEntity<String> response = restTemplate.getForEntity(strudelUrl,String.class);
            String jsonString = response.getBody();

//            System.out.println("JSON String: "+jsonString);

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(jsonString);
            JsonNode root = mapper.readTree(parser);
            strudelResponse = mapper.treeToValue(root,StrudelResponse.class);
            strudelResponse.setNasaQueryRequest(nasaQueryRequest);
            strudelResponse.populateHasArray();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return strudelResponse;
    }

    public Filter getFilter(int id) {
        restTemplate = new RestTemplate();
        Filter filter = null;

        try {
            String filterUrl = "http://localhost:8080/api/filter/"+id;

            ObjectMapper mapper = new ObjectMapper();
            filter = restTemplate.getForObject(filterUrl, Filter.class);
            if(filter != null)
                System.out.println("Filter: "+filter.getId()+", ("+filter.getFilterName()+", "+filter.getFilterContent()+")");


        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return filter;
    }

    public NasaQueryRequest getNasaQueryRequest(int id) {
        restTemplate = new RestTemplate();
        NasaQueryRequest nasaQueryRequest = null;

        try {
            String nasaQueryRequestUrl = "http://localhost:8080/api/nasaQueryRequest/"+id;


//            ResponseEntity<String> response = restTemplate.getForEntity(nasaQueryRequestUrl,String.class);
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(response.getBody());
//            JsonNode filterList = root.path("filterList");
//            System.out.println("filterList: "+filterList.asText());




            nasaQueryRequest = restTemplate.getForObject(nasaQueryRequestUrl, NasaQueryRequest.class);
            if(nasaQueryRequest != null) {
                System.out.println("NasaQueryRequest: " + nasaQueryRequest.getId() + " " + nasaQueryRequest.getFilterList().get(0).getFilterName() + " " + nasaQueryRequest.getFilterList().get(0).getFilterContent());
            }


        } catch(Exception ex) {
            ex.printStackTrace();
        }


        return nasaQueryRequest;
    }
}
