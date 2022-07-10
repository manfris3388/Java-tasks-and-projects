package lt.codeacademy.anestheticChart.mvc.chart.repository;

import lt.codeacademy.anestheticChart.mvc.chart.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
