package lt.codeacademy.anestheticChart.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChartDTO {
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
