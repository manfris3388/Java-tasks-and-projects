package lt.codeacademy.anestheticChart.mapper;

import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.Chart;
import org.springframework.stereotype.Component;

@Component
public class ChartMapper {
  public ChartDTO mapToChartDTO(Chart chart) {
    return ChartDTO.builder()
        .uuid(chart.getUuid())
        .name(chart.getName())
        .surname(chart.getSurname())
        .hospitalNumber(chart.getHospitalNumber())
        .dob(chart.getDob())
        .operation(chart.getOperation())
        .build();
  }
}
