package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChartServiceMock implements ChartService{
    @Override
    public void addCharts(ChartDTO chartDTO) {

    }

    @Override
    public List<ChartDTO> getCharts() {
    return Collections.emptyList();
    }
}
