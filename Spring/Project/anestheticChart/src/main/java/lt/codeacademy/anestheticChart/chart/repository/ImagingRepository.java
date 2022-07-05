package lt.codeacademy.anestheticChart.chart.repository;

import lt.codeacademy.anestheticChart.chart.entity.Imaging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagingRepository extends JpaRepository<Imaging, Long> {
        }