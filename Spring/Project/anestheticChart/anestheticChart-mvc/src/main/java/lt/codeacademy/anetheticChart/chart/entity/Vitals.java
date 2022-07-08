package lt.codeacademy.anetheticChart.chart.entity;

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
@Table(name = "VITALS")
public class Vitals {

    @Id
    private Long chartId;
    private Integer sats;
    private Integer rr;
    private Integer hr;
    private Integer sbp;
    private Integer dbp;
    private String otherVitals;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="chart_id")
    private Chart chart;
//    @OneToOne(mappedBy = "vitals")
//    @MapsId
////    @JoinColumn(name = "chart_id")
//    private Chart chart;
}
