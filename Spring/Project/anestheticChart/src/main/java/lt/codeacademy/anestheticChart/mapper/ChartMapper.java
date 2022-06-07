package lt.codeacademy.anestheticChart.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.entity.*;
import lt.codeacademy.anestheticChart.repository.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ChartMapper {
  private static Long count = 1L;
  private final ChartRepository chartRepository;
  private final ImagingRepository imagingRepository;
  private final LabResRepository labResRepository;
  private final PlanRepository planRepository;
  private final VitalRepository vitalRepository;
  private final AssesmentRepository assesmentRepository;

  public FullChartDTO mapToChartDTO(Chart chart) {
    Long id = chart.getId();
    Assesment assesment = assesmentRepository.findById(id).get();
    Imaging imaging = imagingRepository.findById(id).get();
    LabRes labRes = labResRepository.findById(id).get();
    Plan plan = planRepository.findById(id).get();
    Vitals vitals = vitalRepository.findById(id).get();
    return FullChartDTO.builder()
        .uuid(chart.getUuid())
        .name(chart.getName())
        .surname(chart.getSurname())
        .hospitalNumber(chart.getHospitalNumber())
        .dob(chart.getDob())
        .operation(chart.getOperation())
        .pmh(assesment.getPmh())
        .dh(assesment.getDh())
        .airwayAssessment(assesment.getAirwayAssesment())
        .anestheticAssessment(assesment.getAnestheticAssesment())
        .sats(vitals.getSats())
        .rr(vitals.getRr())
        .hr(vitals.getHr())
        .sbp(vitals.getSbp())
        .dbp(vitals.getDbp())
        .otherVitals(vitals.getOtherVitals())
        .na(labRes.getNa())
        .k(labRes.getK())
        .urea(labRes.getUrea())
        .cr(labRes.getCr())
        .otherLabRes(labRes.getOtherLabRes())
        .ecg(imaging.getEcg())
        .otherIMG(imaging.getOtherIMG())
        .anestheticPlan(plan.getAnestheticPlan())
        .anestheticWorkup(plan.getAnestheticWorkup())
        .build();
  }

  public void saveAllCharts(FullChartDTO chart) {
    saveChart(chart);
    //    saveAssesment(chart, count);
    //    saveImaging(chart, count);
    //    saveToLabResRepo(chart, count);
    //    saveToPlanRepo(chart, count);
    //    saveToVitalsRepo(chart, count);
    count++;
  }

  private void saveChart(FullChartDTO chart) {
    chartRepository.save(
        Chart.builder()
            .uuid(UUID.randomUUID())
            .name(chart.getName())
            .surname(chart.getSurname())
            .hospitalNumber(chart.getHospitalNumber())
            .dob(chart.getDob())
            .operation(chart.getOperation())
            .assesment(
                Assesment.builder()
                    .pmh(chart.getPmh())
                    .dh(chart.getDh())
                    .airwayAssesment(chart.getAirwayAssessment())
                    .anestheticAssesment(chart.getAnestheticAssessment())
                    .build())
            .build());
  }

  public void saveAssesment(FullChartDTO chart, Long id) {
    assesmentRepository.save(
        Assesment.builder()
            .id(id)
            .pmh(chart.getPmh())
            .dh(chart.getDh())
            .airwayAssesment(chart.getAirwayAssessment())
            .anestheticAssesment(chart.getAnestheticAssessment())
            .build());
  }

  public void saveImaging(FullChartDTO chart, Long id) {
    imagingRepository.save(
        Imaging.builder().id(id).ecg(chart.getEcg()).otherIMG(chart.getOtherIMG()).build());
  }

  public void saveToLabResRepo(FullChartDTO chart, Long id) {
    labResRepository.save(
        LabRes.builder()
            .id(id)
            .na(chart.getNa())
            .k(chart.getK())
            .urea(chart.getUrea())
            .cr(chart.getCr())
            .otherLabRes(chart.getOtherLabRes())
            .build());
  }

  public void saveToPlanRepo(FullChartDTO chart, Long id) {
    planRepository.save(
        Plan.builder()
            .id(id)
            .anestheticPlan(chart.getAnestheticPlan())
            .anestheticWorkup(chart.getAnestheticWorkup())
            .build());
  }

  public void saveToVitalsRepo(FullChartDTO chart, Long id) {
    vitalRepository.save(
        Vitals.builder()
            .id(id)
            .sats(chart.getSats())
            .rr(chart.getRr())
            .hr(chart.getHr())
            .sbp(chart.getSbp())
            .dbp(chart.getDbp())
            .otherVitals(chart.getOtherVitals())
            .build());
  }
}
