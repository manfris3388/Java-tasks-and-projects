package lt.codeacademy.anestheticChart.chart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LAB_RES")
public class LabRes {

    @Id
    private Long chartId;

    private Integer na;
    private Double k;
    private Double urea;
    private Integer cr;
    @Column(name = "other_lab_res")
    private String otherLabRes;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="chart_id")
    private Chart chart;
//    @OneToOne(mappedBy = "labRes")
//    @MapsId
////    @JoinColumn(name = "chart_id")
//    private Chart chart;
}
