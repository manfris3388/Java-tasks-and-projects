package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChartServiceImp implements ChartService {

    private final ChartRepository chartRepository;

    @Override
    public void addCharts(ChartDTO chartDTO){
        chartRepository.save(chartDTO);
    }

    @Override
    public List<ChartDTO> getCharts() {
        return chartRepository.getCharts();
    }
}
