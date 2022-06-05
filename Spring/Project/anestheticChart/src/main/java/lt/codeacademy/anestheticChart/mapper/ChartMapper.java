package lt.codeacademy.anestheticChart.mapper;

import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.entity.Chart;
import org.springframework.stereotype.Component;

@Component
public class ChartMapper {
  public FullChartDTO mapToChartDTO(Chart chart) {
    return FullChartDTO.builder()
        .uuid(chart.getUuid())
        .name(chart.getName())
        .surname(chart.getSurname())
        .hospitalNumber(chart.getHospitalNumber())
        .dob(chart.getDob())
        .operation(chart.getOperation())
        .build();
  }
}
