package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaCollectionId")
    private Integer id;

//    @Version
//    private Integer version;

    @JsonProperty("metadata")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NasaCollectionMetadata nasaCollectionMetadata;

    @JsonProperty("href")
    private String collectionUrl;

    @JsonProperty("version")
    private String collectionVersion;

    @JsonProperty("items")
    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NasaItem> nasaItemList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NasaQueryRequest nasaQueryRequest;

    @JsonProperty("links")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NasaLink> nasaLinkList;

}

