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
@Table(name = "PLANS")
public class Plan {

  @Id
  private Long chartId;
  private String anestheticPlan;
  private String anestheticWorkup;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name="chart_id")
  private Chart chart;
}
