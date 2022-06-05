package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.entity.Imaging;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagingRepository extends JpaRepository<Imaging, Long> {
        Optional<Imaging> findById(Id id);
        }