package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaItemLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaDataLinkId")
    private Integer id;

    @Version
    private Integer version;

    private String rel;
    private String href;
    private String render;

    NasaItemLink() {}
    NasaItemLink(String rel, String href, String render) {
        this.setRel(rel);
        this.setHref(href);
        this.setRender(render);
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

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }
}
