package lt.codeacademy.anestheticChart.jpa.repositories.chart_mvc;

import lt.codeacademy.anestheticChart.jpa.entity.chart_mvc.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRepository extends JpaRepository<Vitals, Long> {
}
