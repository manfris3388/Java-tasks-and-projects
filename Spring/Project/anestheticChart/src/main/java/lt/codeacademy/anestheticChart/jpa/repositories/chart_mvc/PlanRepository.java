package lt.codeacademy.anestheticChart.jpa.repositories.chart_mvc;

import lt.codeacademy.anestheticChart.jpa.entities.chart_mvc.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
