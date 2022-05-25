package lt.codeacademy.anestheticChart.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ChartDTO {
    private UUID uuid;
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
