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
@Table(name = "lab_res")
public class LabRes {
    @Id
    @Column(name = "chart_id")
    private Long id;
    private Integer na;
    private Double k;
    private Double urea;
    private Integer cr;
    @Column(name = "other_lab_res")
    private String otherLabRes;
    @OneToOne
    @MapsId
    @JoinColumn(name = "chart_id")
    private Chart chart;
}
