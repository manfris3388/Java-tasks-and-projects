package lt.codeacademy.anestheticChart.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.anestheticChart.mvc.chart.dto.FullChartDTO;

import java.util.List;

@Builder
@Getter
public class ChartsResponse {
    private List<FullChartDTO> charts;
}
