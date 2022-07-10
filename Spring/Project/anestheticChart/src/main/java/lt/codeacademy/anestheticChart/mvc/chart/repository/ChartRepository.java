package lt.codeacademy.anestheticChart.mvc.chart.repository;

import lt.codeacademy.anestheticChart.mvc.chart.entity.Chart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {
    Optional<Chart> findByUuid(UUID uuid);

    Page<Chart> findBySurnameIsLikeIgnoreCase(String surname, Pageable pageable);
}
