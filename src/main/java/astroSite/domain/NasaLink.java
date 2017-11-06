package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaLinkId")
    private Integer id;

    @Version
    private Integer version;

    @JsonProperty("rel")
    private String rel;
    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("href")
    private String nasaLinkUrl;

    public NasaLink() {}
    public NasaLink(String url) {
        this.setNasaLinkUrl(url);
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

    public String getNasaLinkUrl() {
        return nasaLinkUrl;
    }

    public void setNasaLinkUrl(String nasaLinkUrl) {
        this.nasaLinkUrl = nasaLinkUrl;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}