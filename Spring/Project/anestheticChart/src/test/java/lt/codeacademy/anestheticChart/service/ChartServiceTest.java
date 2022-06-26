package lt.codeacademy.anestheticChart.service;

import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.entity.Chart;
import lt.codeacademy.anestheticChart.mapper.ChartMapper;
import lt.codeacademy.anestheticChart.model.ChartDtoMother;
import lt.codeacademy.anestheticChart.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ChartServiceTest {

  @Mock private ChartRepository chartRepository;

  @Mock private AssesmentRepository assesmentRepository;

  @Mock private ImagingRepository imagingRepository;

  @Mock private LabResRepository labResRepository;

  @Mock private PlanRepository planRepository;

  @Mock private VitalRepository vitalRepository;

  @Mock private ChartMapper chartMapper;

  @InjectMocks private ChartService chartService;

  @Test
  void testAddChart_AddingName() {
    // given
    FullChartDTO chartDTO = ChartDtoMother.getPartial();
    // when
    chartService.addChart(chartDTO);
    // then
      verify(chartRepository, times(1)).save(Chart.builder()
              .name("Jonelis")
              .build());
  }
}
