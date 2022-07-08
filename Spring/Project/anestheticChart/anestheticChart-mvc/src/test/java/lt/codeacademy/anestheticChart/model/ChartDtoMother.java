package lt.codeacademy.anestheticChart.model;

import lt.codeacademy.anestheticChart.chart.dto.FullChartDTO;

public class ChartDtoMother {
    private static final String NAME = "Jonelis";

    public static FullChartDTO getPartial(){
        return FullChartDTO.builder()
                .name(NAME)
                .build();
    }
}
