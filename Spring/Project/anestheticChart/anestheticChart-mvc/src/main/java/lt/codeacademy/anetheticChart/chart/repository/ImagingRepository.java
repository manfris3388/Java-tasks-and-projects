package lt.codeacademy.anetheticChart.chart.repository;

import lt.codeacademy.anetheticChart.chart.entity.Imaging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagingRepository extends JpaRepository<Imaging, Long> {
        }