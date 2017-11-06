package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaMetadataId")
    private Integer id;

    @Version
    private Integer version;

    private String nasaMetadataUrl;
    private HashMap<String, Object> dataMap;

    public NasaMetadata() {}
    public NasaMetadata(String url) {
        this.setNasaMetadataUrl(url);
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

    public String getNasaMetadataUrl() {
        return nasaMetadataUrl;
    }

    public void setNasaMetadataUrl(String nasaMetadataUrl) {
        this.nasaMetadataUrl = nasaMetadataUrl;
    }

    public HashMap<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, Object> dataMap) {
        this.dataMap = dataMap;
    }
}