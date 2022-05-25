package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.ChartEntity;
import lt.codeacademy.anestheticChart.mapper.ChartMapper;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChartService {

    private final ChartRepository chartRepository;
    private final ChartMapper chartMapper;

    public void addChart(ChartDTO chartDTO){
        chartRepository.save(ChartEntity
                .builder()
                .uuid(UUID.randomUUID())
                .name(chartDTO.getName())
                .surname(chartDTO.getSurname())
                .hospitalNumber(chartDTO.getHospitalNumber())
                .dob(chartDTO.getDob())
                .operation(chartDTO.getOperation())
                .build());
    }

    public List<ChartDTO> getCharts() {
        return chartRepository.findAll()
                .stream()
                .map(chartMapper::mapToChartDTO)
                .collect(Collectors.toList());
    }

    public ChartDTO getChartByUUID(UUID uuid){
//        return chartRepository.getChartByUUID(uuid);
        return null;
    }

    public void updateChart(ChartDTO chartDTO) {
//        chartRepository.updateChart(chartDTO);
    }

    public void deleteChart(UUID uuid) {
//        chartRepository.deleteChart(uuid);
    }
}
