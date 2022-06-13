package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.entity.Imaging;
import lt.codeacademy.anestheticChart.entity.LabRes;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabResRepository extends JpaRepository<LabRes, Long> {
}