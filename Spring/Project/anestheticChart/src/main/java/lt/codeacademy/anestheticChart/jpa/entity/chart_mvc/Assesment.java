package lt.codeacademy.anestheticChart.jpa.entity.chart_mvc;

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
@Table(name = "ASSESMENT")
public class Assesment {

    @Id
    private Long chartId;
    private String pmh;
    private String dh;
    private String airwayAssesment;
    private String anestheticAssesment;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="chart_id")
    private Chart chart;
}
