package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaQueryRequest {

    public static final String[] filterTypes = {"q",           //0 "searchText"
                                                "center",      //1 "nasaCenter"
                                                "description", //2 "descriptionTerms"
                                                "keywords",    //3 "keywordTerms"
                                                "location",    //4 "locationTerms"
                                                "media_type",  //5 "mediaType"
                                                "nasa_id",     //6 "nasaId"
                                                "photographer",//7 "photographerName"
                                                "title",       //8 "title"
                                                "year_start",  //9 "yearStart"
                                                "year_end"};   //10"yearEnd"

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaQueryRequestId")
    private Integer id;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Filter> filterList;


    public NasaQueryRequest() {}
    public NasaQueryRequest(List<Filter> aList) {
        this.setFilterList(aList);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Filter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Filter> filterList) {
        this.filterList = filterList;
    }

    //Custom Methods
    public String makeRequestUrl() {
        StringBuilder sb = new StringBuilder("https://images-api.nasa.gov/search?");
        String fix;

        for(int i=0;i<this.filterList.size();i++) {
            sb.append(this.filterList.get(i).getFilterName());
            sb.append("=");
//            if(!this.filterList.get(i).getFilterContent().contains(" "))
//                sb.append(this.filterList.get(i).getFilterContent());
//            else {
//                fix = this.filterList.get(i).getFilterContent().replaceAll(" ","%20");
//                sb.append(fix);
//            }
            sb.append(this.filterList.get(i).getFilterContent());
            if(i<this.filterList.size()-1)
                sb.append("&");
        }
//        System.out.println("URL: "+sb);

        return sb.toString();
    }
}
