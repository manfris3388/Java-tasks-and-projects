package lt.codeacademy.anestheticChart.chart.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
public class FullChartDTO {
    private UUID uuid;

    @NotBlank(message = "{name.blank}")
    @Size(
            min = 3,
            max = 40,
            message = "Name turi buti daugiau nei {min} ir maziau nei {max}"
    )
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
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
