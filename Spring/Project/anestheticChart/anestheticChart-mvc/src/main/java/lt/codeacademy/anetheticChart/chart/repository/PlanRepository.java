package lt.codeacademy.anetheticChart.chart.repository;

import lt.codeacademy.anetheticChart.chart.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
