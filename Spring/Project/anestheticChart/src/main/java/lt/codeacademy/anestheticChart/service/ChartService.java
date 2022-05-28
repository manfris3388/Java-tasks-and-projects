package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.ChartEntity;
import lt.codeacademy.anestheticChart.exceptions.NoSuchAnestheticChartException;
import lt.codeacademy.anestheticChart.mapper.ChartMapper;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChartService {

  private final ChartRepository chartRepository;
  private final ChartMapper chartMapper;

  public void addChart(ChartDTO chartDTO) {
    chartRepository.save(
        ChartEntity.builder()
            .uuid(UUID.randomUUID())
            .name(chartDTO.getName())
            .surname(chartDTO.getSurname())
            .hospitalNumber(chartDTO.getHospitalNumber())
            .dob(chartDTO.getDob())
            .operation(chartDTO.getOperation())
            .build());
  }

  public Page<ChartDTO> getChartsPaginated(Pageable pageable) {
    return chartRepository.findAll(pageable).map(chartMapper::mapToChartDTO);
  }

  public List<ChartDTO> getCharts() {
    return chartRepository.findAll().stream()
        .map(chartMapper::mapToChartDTO)
        .collect(Collectors.toList());
  }

  public ChartDTO getChartByUUID(UUID uuid) {
    return chartRepository.findByUuid(uuid).map(chartMapper::mapToChartDTO).orElseThrow(NoSuchAnestheticChartException::new);
  }

  @Transactional
  public void updateChart(ChartDTO chartDTO) {
    Optional<ChartEntity> chartEntityOptional = chartRepository.findByUuid(chartDTO.getUuid());
    if (chartEntityOptional.isPresent()) {
      ChartEntity chartEntity =
          chartEntityOptional.get().toBuilder()
              .name(chartDTO.getName())
              .surname(chartDTO.getSurname())
              .hospitalNumber(chartDTO.getHospitalNumber())
              .dob(chartDTO.getDob())
              .operation(chartDTO.getOperation())
              .build();
      chartRepository.save(chartEntity);
    }
  }

  //makes a check if entity is present and deletes it if it is not null
  @Transactional
  public void deleteChart(UUID uuid) {
    Optional<ChartEntity> chartEntityOptional = chartRepository.findByUuid(uuid);
    chartEntityOptional.ifPresent(chartRepository::delete);
  }
}
