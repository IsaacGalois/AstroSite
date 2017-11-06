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
public class StrudelCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StrudelCategoryId")
    private Integer id;

    @Version
    private Integer version;

    private String avmcode;
    private String avmdesc;
}