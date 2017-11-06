package astroSite.domain;

import javax.persistence.*;

@Entity
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FilterId")
    private Integer id;

    @Version
    private Integer version;

    private String filterName;
    private String filterContent;

    public Filter() {}
    public Filter(String filterName, String filterContent) {
        this.setFilterName(filterName);
        this.setFilterContent(filterContent);
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

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterContent() {
        return filterContent;
    }

    public void setFilterContent(String filterContent) {
        this.filterContent = filterContent;
    }
}