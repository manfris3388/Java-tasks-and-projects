package lt.codeacademy.anestheticChart.chart.repository;

import lt.codeacademy.anestheticChart.chart.entity.Assesment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssesmentRepository extends JpaRepository<Assesment, Long> {
}
