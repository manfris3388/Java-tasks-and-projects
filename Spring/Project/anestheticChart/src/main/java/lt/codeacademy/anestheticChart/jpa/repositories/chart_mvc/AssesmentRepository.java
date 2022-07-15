package lt.codeacademy.anestheticChart.jpa.repositories.chart_mvc;

import lt.codeacademy.anestheticChart.jpa.entity.chart_mvc.Assesment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssesmentRepository extends JpaRepository<Assesment, Long> {
}
