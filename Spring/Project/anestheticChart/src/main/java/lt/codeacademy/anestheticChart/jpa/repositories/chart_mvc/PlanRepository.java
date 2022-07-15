package lt.codeacademy.anestheticChart.jpa.repositories.chart_mvc;

import lt.codeacademy.anestheticChart.jpa.entity.chart_mvc.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
