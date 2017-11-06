package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaCollectionId")
    private Integer id;

    @Version
    private Integer version;

    @JsonProperty("href")
    private String nasaItemUrl;

    @JsonProperty("data")
    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NasaData> nasaDataList;

    @JsonProperty("links")
    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NasaItemLink> nasaLinkList;

    public NasaItem() {}
    public NasaItem(String url) {
        this.setNasaItemUrl(url);
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

    public String getNasaItemUrl() {
        return nasaItemUrl;
    }

    public void setNasaItemUrl(String nasaItemUrl) {
        this.nasaItemUrl = nasaItemUrl;
    }

    public List<NasaData> getNasaDataList() {
        return nasaDataList;
    }

    public void setNasaDataList(List<NasaData> nasaDataList) {
        this.nasaDataList = nasaDataList;
    }


    public List<NasaItemLink> getNasaLinkList() {
        return nasaLinkList;
    }

    public void setNasaLinkList(List<NasaItemLink> nasaLinkList) {
        this.nasaLinkList = nasaLinkList;
    }
}
