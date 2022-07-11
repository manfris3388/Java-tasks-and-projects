package lt.codeacademy.anestheticChart.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.anestheticChart.mvc.chart.dto.FullChartDTO;

import java.util.List;

@Builder
@Getter
public class ChartsResponse {

    @ApiModelProperty(notes = "Charts list", required = true, allowEmptyValue = false)
    private List<FullChartDTO> charts;
}
