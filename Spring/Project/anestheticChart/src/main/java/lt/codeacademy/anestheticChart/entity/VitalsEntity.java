package lt.codeacademy.anestheticChart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VITALS")
public class VitalsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private Integer rr;
  private Integer hr;
  private Integer sbp;
  private Integer dbp;
  private String otherVitals;
}
