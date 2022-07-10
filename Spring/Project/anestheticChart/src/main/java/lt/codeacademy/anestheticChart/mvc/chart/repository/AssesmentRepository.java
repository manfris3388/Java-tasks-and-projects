package lt.codeacademy.anestheticChart.mvc.chart.repository;

import lt.codeacademy.anestheticChart.mvc.chart.entity.Assesment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssesmentRepository extends JpaRepository<Assesment, Long> {
}
