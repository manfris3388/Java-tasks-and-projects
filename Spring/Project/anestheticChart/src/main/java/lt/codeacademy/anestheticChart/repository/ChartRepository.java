package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.ChartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChartRepository extends JpaRepository<ChartEntity, Long> {

}
