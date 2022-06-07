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
@Table(name = "PLANS")
public class Plan {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name = "chart_id")
  private Long id;
  private String anestheticPlan;
  private String anestheticWorkup;
//  @OneToOne(mappedBy = "plan")
//  @MapsId
////  @JoinColumn(name = "chart_id")
//  private Chart chart;
}
