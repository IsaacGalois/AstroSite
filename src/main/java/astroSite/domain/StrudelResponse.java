package astroSite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StrudelResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StrudelResponseId")
    private Integer id;

    @Version
    private Integer version;

    @JsonProperty("target")     //0
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelTarget strudelTarget;

    @JsonProperty("service")    //1
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelServOb strudelServOb;

    @JsonProperty("coordsys")   //2
    private String coordsys;

    @JsonProperty("equinox")    //3
    private String equinox;

    @JsonProperty("ra")         //4
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelRA strudelRA;

    @JsonProperty("dec")        //5
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelDec strudelDec;

    @JsonProperty("galactic")   //6
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelGalactic strudelGalactic;

    @JsonProperty("jd")         //7
    private Double jd;

    @JsonProperty("image")      //8
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelImage strudelImage;

    @JsonProperty("category")   //9
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StrudelCategory strudelCategory;

    private Integer[] hasArray;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private NasaQueryRequest nasaQueryRequest;

    //Helper Methods
    public void populateHasArray() {
        Integer[] newArray = {0,0,0,0,0,0,0,0,0,0};
        if(this.strudelTarget != null)
            newArray[0] = 1;
        if(this.strudelServOb != null)
            newArray[1] = 1;
        if(this.coordsys != null)
            newArray[2] = 1;
        if(this.equinox != null)
            newArray[3] = 1;
        if(this.strudelRA != null)
            newArray[4] = 1;
        if(this.strudelDec != null)
            newArray[5] = 1;
        if(this.strudelGalactic != null)
            newArray[6] = 1;
        if(this.jd != null)
            newArray[7] = 1;
        if(this.strudelImage != null)
            newArray[8] = 1;
        if(this.strudelCategory != null)
            newArray[9] = 1;

//        System.out.println(Arrays.toString(newArray));

        this.hasArray = newArray;

    }
}