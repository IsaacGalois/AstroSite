package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StrudelDec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StrudelDecId")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "decDecimal", precision = 10, scale = 7)
    @JsonProperty("decimal")
    private BigDecimal decimal;
    private String d;
    private String m;
    private String s;
}