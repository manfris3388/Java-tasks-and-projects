package lt.codeacademy.anestheticChart.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "vitals")
public class PatientVitalsEntity {
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "chart_id")
  private Long id;
  private Integer sats;
  private Integer rr;
  private Integer hr;
  private Integer sbp;
  private Integer dbp;
  @Column(name = "other_vitals")
  private String otherVitals;
  @OneToOne
  @MapsId
  @JoinColumn(name = "chart_id")
  private ChartEntity chartEntity;
//  @OneToOne
//  @MapsId
//  @JoinColumn(name = "ANESTHETIC_CHARTS_id")
//  ChartEntity chartEntity;
//  @ManyToMany(mappedBy = "patientVitalsEntities")
//  private Set<ChartEntity> chartEntities;
}
