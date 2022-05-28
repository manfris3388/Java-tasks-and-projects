package lt.codeacademy.anestheticChart.repository;

import lt.codeacademy.anestheticChart.entity.ChartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ChartRepository extends JpaRepository<ChartEntity, Long> {
    Optional<ChartEntity> findByUuid(UUID uuid);
}
