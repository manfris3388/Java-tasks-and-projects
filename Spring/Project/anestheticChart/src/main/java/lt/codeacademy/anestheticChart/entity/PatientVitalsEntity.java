package lt.codeacademy.anestheticChart.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "patient_vitals")
public class PatientVitalsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  private Integer sats;
  private Integer rr;
  private Integer hr;
  private Integer sbp;
  private Integer dbp;
  @Column(name = "other_vitals")
  private String otherVitals;
//  @ManyToMany(mappedBy = "patientVitalsEntities")
//  private Set<ChartEntity> chartEntities;
}
