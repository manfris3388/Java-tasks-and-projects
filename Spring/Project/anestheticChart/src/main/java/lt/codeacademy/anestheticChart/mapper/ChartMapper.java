package lt.codeacademy.anestheticChart.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.entity.*;
import lt.codeacademy.anestheticChart.repository.*;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChartMapper {
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
}
