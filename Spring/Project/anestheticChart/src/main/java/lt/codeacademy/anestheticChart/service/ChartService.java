package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.Chart;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChartService {

    private final ChartRepository chartRepository;

    public void addCharts(Chart chart){
        chartRepository.save(chart);
    }

    public List<Chart> getCharts() {
        return chartRepository.getCharts();
    }
}
