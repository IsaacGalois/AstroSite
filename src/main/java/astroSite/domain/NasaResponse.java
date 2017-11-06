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
public class NasaResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NasaResponseId")
    private Integer id;

    @Version
    private Integer version;

    @JsonProperty("collection")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NasaCollection nasaCollection;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NasaQueryRequest nasaQueryRequest;
}