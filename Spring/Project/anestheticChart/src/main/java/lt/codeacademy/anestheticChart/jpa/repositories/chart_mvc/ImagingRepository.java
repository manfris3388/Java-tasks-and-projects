package lt.codeacademy.anestheticChart.jpa.repositories.chart_mvc;

import lt.codeacademy.anestheticChart.jpa.entities.chart_mvc.Imaging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagingRepository extends JpaRepository<Imaging, Long> {
        }