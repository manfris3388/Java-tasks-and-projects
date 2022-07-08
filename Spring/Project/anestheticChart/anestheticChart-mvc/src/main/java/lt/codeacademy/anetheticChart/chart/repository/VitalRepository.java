package lt.codeacademy.anetheticChart.chart.repository;

import lt.codeacademy.anetheticChart.chart.entity.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalRepository extends JpaRepository<Vitals, Long> {
}
