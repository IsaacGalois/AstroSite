package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaDataId")
    private Integer id;

    @Version
    private Integer version;

    private String center;
    private String date_created;

    @Column(name="description", columnDefinition = "MEDIUMTEXT")
    private String description;
    @JsonProperty("keywords")
    @ElementCollection(targetClass=String.class)
    private List<String> keywordList;
    private String media_type;
    @JsonProperty("nasa_id")
    private String nasaId;
    @JsonProperty("photographer")
    private String photographerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NasaMetadata> nasaMetadataList;
}