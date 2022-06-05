package lt.codeacademy.anestheticChart.entity;

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
@Table(name = "assesment")
public class Assesment {
    @Id
    @Column(name = "chart_id")
    private Long id;
    private String pmh;
    private String dh;
    private String airwayAssesment;
    private String anestheticAssesment;
    @OneToOne
    @MapsId
    @JoinColumn(name = "chart_id")
    private Chart chart;
}
