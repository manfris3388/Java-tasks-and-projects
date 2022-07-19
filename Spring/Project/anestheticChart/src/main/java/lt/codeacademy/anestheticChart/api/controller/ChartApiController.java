package lt.codeacademy.anestheticChart.api.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.dto.ChartsResponse;
import lt.codeacademy.anestheticChart.mvc.chart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.mvc.chart.service.ChartService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Profile("rest")
@RestController
@RequiredArgsConstructor
public class ChartApiController implements ChartApiSpecs {

  private final ChartService chartService;

  public ChartsResponse getCharts() {
    return ChartsResponse.builder().charts(chartService.getCharts()).build();
  }

  public ChartsResponse getCharts(@PathVariable("uuid") UUID uuid) {
    return ChartsResponse.builder().charts(List.of(chartService.getFullChartByUUID(uuid))).build();
  }

  public Page<FullChartDTO> getChartsPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return chartService.getChartsPaginated(PageRequest.of(page, size));
  }

  public void deleteChart(UUID chartUUID) {
    chartService.deleteChart(chartUUID);
  }

  public ResponseEntity<Void> createChart(FullChartDTO fullChartDTO) {

    chartService.addChart(fullChartDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  public ResponseEntity<Void> updateChart(FullChartDTO fullChartDTO) {
    if (chartService.updateChart(fullChartDTO)) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    return ResponseEntity.notFound().build();
  }
}
