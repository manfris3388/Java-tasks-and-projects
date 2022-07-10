package lt.codeacademy.anestheticChart.mvc.chart.repository;

import lt.codeacademy.anestheticChart.mvc.chart.entity.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRepository extends JpaRepository<Vitals, Long> {
}
