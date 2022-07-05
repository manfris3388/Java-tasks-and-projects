package lt.codeacademy.anestheticChart.chart.repository;

import lt.codeacademy.anestheticChart.chart.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
