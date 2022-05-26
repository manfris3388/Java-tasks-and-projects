package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.ChartEntity;
import lt.codeacademy.anestheticChart.mapper.ChartMapper;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

  public List<ChartDTO> getCharts() {
    return chartRepository.findAll().stream()
        .map(chartMapper::mapToChartDTO)
        .collect(Collectors.toList());
  }

  public ChartDTO getChartByUUID(UUID uuid) {
    return chartMapper.mapToChartDTO(chartRepository.findByUuid(uuid));
  }

  @Transactional
  public void updateChart(ChartDTO chartDTO) {
    ChartEntity chartEntity =
        chartRepository.findByUuid(chartDTO.getUuid()).toBuilder()
            .name(chartDTO.getName())
            .surname(chartDTO.getSurname())
            .hospitalNumber(chartDTO.getHospitalNumber())
            .dob(chartDTO.getDob())
            .operation(chartDTO.getOperation())
            .build();
    chartRepository.save(chartEntity);
  }

  @Transactional
  public void deleteChart(UUID uuid) {
    chartRepository.delete(chartRepository.findByUuid(uuid));
  }
}
