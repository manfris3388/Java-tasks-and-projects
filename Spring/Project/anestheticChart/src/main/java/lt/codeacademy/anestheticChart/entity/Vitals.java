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
@Table(name = "VITALS")
public class Vitals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "chart_id")
    private Long id;
    private Integer sats;
    private Integer rr;
    private Integer hr;
    private Integer sbp;
    private Integer dbp;
    private String otherVitals;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Chart chart;
//    @OneToOne(mappedBy = "vitals")
//    @MapsId
////    @JoinColumn(name = "chart_id")
//    private Chart chart;
}
