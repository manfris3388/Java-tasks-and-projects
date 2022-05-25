package lt.codeacademy.anestheticChart.mapper;

import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.ChartEntity;
import org.springframework.stereotype.Component;

@Component
public class ChartMapper {
  public ChartDTO mapToChartDTO(ChartEntity chartEntity) {
    return ChartDTO.builder()
        .uuid(chartEntity.getUuid())
        .name(chartEntity.getName())
        .surname(chartEntity.getSurname())
        .hospitalNumber(chartEntity.getHospitalNumber())
        .dob(chartEntity.getDob())
        .operation(chartEntity.getOperation())
        .build();
  }
}
