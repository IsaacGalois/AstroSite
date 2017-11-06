package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaCollectionMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaCollectionMetadataId")
    private Integer id;

    @Version
    private Integer version;

    @JsonProperty("total_hits")
    private Integer totalHits;

//    @OneToOne
//    private NasaQueryRequest nasaQueryRequest;
}
