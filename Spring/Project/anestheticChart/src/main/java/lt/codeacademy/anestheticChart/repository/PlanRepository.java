package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.entity.Plan;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
