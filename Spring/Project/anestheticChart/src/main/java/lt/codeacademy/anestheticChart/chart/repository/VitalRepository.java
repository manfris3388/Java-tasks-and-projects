package lt.codeacademy.anestheticChart.chart.repository;

import lt.codeacademy.anestheticChart.chart.entity.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRepository extends JpaRepository<Vitals, Long> {
}
