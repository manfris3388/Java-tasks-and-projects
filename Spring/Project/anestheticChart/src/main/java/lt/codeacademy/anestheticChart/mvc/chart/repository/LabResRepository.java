package lt.codeacademy.anestheticChart.mvc.chart.repository;

import lt.codeacademy.anestheticChart.mvc.chart.entity.LabRes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabResRepository extends JpaRepository<LabRes, Long> {
}