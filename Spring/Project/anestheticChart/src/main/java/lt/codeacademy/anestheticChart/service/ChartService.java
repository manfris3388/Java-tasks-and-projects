package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChartService {

    private final ChartRepository chartRepository;

    public void addCharts(ChartDTO chartDTO){
        chartRepository.save(chartDTO);
    }
}
