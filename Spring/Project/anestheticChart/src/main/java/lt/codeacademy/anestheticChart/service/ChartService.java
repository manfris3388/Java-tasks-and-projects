package lt.codeacademy.anestheticChart.service;

import lt.codeacademy.anestheticChart.model.ChartDTO;

import java.util.List;

public interface ChartService {
    void addCharts(ChartDTO chartDTO);
    List<ChartDTO> getCharts();
}
