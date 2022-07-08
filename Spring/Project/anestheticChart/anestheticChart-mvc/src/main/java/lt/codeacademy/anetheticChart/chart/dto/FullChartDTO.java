package lt.codeacademy.anetheticChart.chart.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
public class FullChartDTO {
    private UUID uuid;

    @NotBlank(message = "{validate.name.blank}")
    @Size(
            min = 3,
            max = 20,
            message = "{validate.name.size}"
    )
    private String name;

    @NotBlank(message = "{validate.surname.blank}")
    @Size(
            min = 3,
            max = 20,
            message = "{validate.surname.size}"
    )
    private String surname;

    @NotBlank(message = "{validate.hospitalNumber.blank}")
    @Size(
            max = 20,
            message = "{validate.hospitalNumber.size}"
    )
    private String hospitalNumber;

    @NotBlank(message = "{validate.dob.blank}")
    @Size(
            max = 20,
            message = "{validate.dob.size}"
    )
    private String dob;

    @NotBlank(message = "{validate.operation.blank}")
    @Size(
            max = 20,
            message = "{validate.operation.size}"
    )
    private String operation;

    private String pmh;
    private String dh;
    private String airwayAssessment;
    private String anestheticAssessment;
    private Integer sats;
    private Integer rr;
    private Integer hr;
    private Integer sbp;
    private Integer dbp;
    private String otherVitals;
    private Integer na;
    private Double k;
    private Double urea;
    private Integer cr;
    private String otherLabRes;
    private String ecg;
    private String otherIMG;
    private String anestheticPlan;
    private String anestheticWorkup;
}
