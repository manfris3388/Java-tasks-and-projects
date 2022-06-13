package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.entity.Assesment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssesmentRepository extends JpaRepository<Assesment, Long> {
}
