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
@Table(name = "ASSESMENT")
public class Assesment {
    @Id
    private Long id;

    private String pmh;
    private String dh;
    private String airwayAssesment;
    private String anestheticAssesment;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Chart chart;
}
