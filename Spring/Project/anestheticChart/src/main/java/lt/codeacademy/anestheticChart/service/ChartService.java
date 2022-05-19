package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.Chart;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Chart getChartByUUID(UUID uuid){
        return chartRepository.getChartByUUID(uuid);
    }
}
