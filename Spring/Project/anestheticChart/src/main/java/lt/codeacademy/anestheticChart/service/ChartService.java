package lt.codeacademy.anestheticChart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.entity.*;
import lt.codeacademy.anestheticChart.exceptions.NoSuchAnestheticChartException;
import lt.codeacademy.anestheticChart.mapper.ChartMapper;
import lt.codeacademy.anestheticChart.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChartService {

  private final ChartRepository chartRepository;

  private final AssesmentRepository assesmentRepository;

  private final ImagingRepository imagingRepository;

  private final LabResRepository labResRepository;

  private final PlanRepository planRepository;

  private final VitalRepository vitalRepository;

  private final ChartMapper chartMapper;

  @Transactional
  public void addChart(FullChartDTO fullChartDTO) {
    // TODO: refactor this in other services, not mappers
    Chart chart =
        chartRepository.save(
            Chart.builder()
                .uuid(UUID.randomUUID())
                .name(fullChartDTO.getName())
                .surname(fullChartDTO.getSurname())
                .hospitalNumber(fullChartDTO.getHospitalNumber())
                .dob(fullChartDTO.getDob())
                .operation(fullChartDTO.getOperation())
                .build());

    assesmentRepository.save(
        Assesment.builder()
            .pmh(fullChartDTO.getPmh())
            .dh(fullChartDTO.getDh())
            .airwayAssesment(fullChartDTO.getAirwayAssessment())
            .anestheticAssesment(fullChartDTO.getAnestheticAssessment())
            .chart(chart)
            .build());

    vitalRepository.save(
        Vitals.builder()
            .sats(fullChartDTO.getSats())
            .rr(fullChartDTO.getRr())
            .hr(fullChartDTO.getHr())
            .sbp(fullChartDTO.getSbp())
            .dbp(fullChartDTO.getDbp())
            .otherVitals(fullChartDTO.getOtherVitals())
            .chart(chart)
            .build());

    labResRepository.save(
        LabRes.builder()
            .na(fullChartDTO.getNa())
            .k(fullChartDTO.getK())
            .urea(fullChartDTO.getUrea())
            .cr(fullChartDTO.getCr())
            .otherLabRes(fullChartDTO.getOtherLabRes())
            .chart(chart)
            .build());

    imagingRepository.save(
        Imaging.builder()
            .ecg(fullChartDTO.getEcg())
            .otherIMG(fullChartDTO.getOtherIMG())
            .chart(chart)
            .build());

    planRepository.save(
        Plan.builder()
            .anestheticPlan(fullChartDTO.getAnestheticPlan())
            .anestheticWorkup(fullChartDTO.getAnestheticWorkup())
            .chart(chart)
            .build());
  }

  public Page<FullChartDTO> getChartsPaginated(Pageable pageable) {
    return chartRepository.findAll(pageable).map(chartMapper::mapToChartDTO);
  }

  public List<FullChartDTO> getCharts() {
    return chartRepository.findAll().stream()
        .map(chartMapper::mapToChartDTO)
        .collect(Collectors.toList());
  }

  public FullChartDTO getFullChartByUUID(UUID uuid) {
    return chartRepository
        .findByUuid(uuid)
        .map(chartMapper::mapToChartDTO)
        .orElseThrow(NoSuchAnestheticChartException::new);
  }

  @Transactional
  public void updateChart(FullChartDTO fullChartDTO) {
    Optional<Chart> chartOptional = chartRepository.findByUuid(fullChartDTO.getUuid());
    if (chartOptional.isPresent()) {
      Chart chart =
          chartOptional.get().toBuilder()
              .name(fullChartDTO.getName())
              .surname(fullChartDTO.getSurname())
              .hospitalNumber(fullChartDTO.getHospitalNumber())
              .dob(fullChartDTO.getDob())
              .operation(fullChartDTO.getOperation())
              .build();
      chartRepository.save(chart);

      Long id = chart.getId();

      Assesment assesment = assesmentRepository.getById(id);
      assesment =
              assesment.toBuilder()
                      .pmh(fullChartDTO.getPmh())
                      .dh(fullChartDTO.getDh())
                      .airwayAssesment(fullChartDTO.getAirwayAssessment())
                      .anestheticAssesment(fullChartDTO.getAnestheticAssessment())
                      .chart(chart)
                      .build();
      assesmentRepository.save(assesment);

      Vitals vitals =vitalRepository.getById(id);
      vitals =
              vitals.toBuilder()
                      .sats(fullChartDTO.getSats())
                      .rr(fullChartDTO.getRr())
                      .hr(fullChartDTO.getHr())
                      .sbp(fullChartDTO.getSbp())
                      .dbp(fullChartDTO.getDbp())
                      .otherVitals(fullChartDTO.getOtherVitals())
                      .chart(chart)
                      .build();
      vitalRepository.save(vitals);

      LabRes labRes = labResRepository.getById(id);
      labRes =
              labRes.toBuilder()
                      .na(fullChartDTO.getNa())
                      .k(fullChartDTO.getK())
                      .urea(fullChartDTO.getUrea())
                      .cr(fullChartDTO.getCr())
                      .otherLabRes(fullChartDTO.getOtherLabRes())
                      .chart(chart)
                      .build();
      labResRepository.save(labRes);

      Imaging imaging = imagingRepository.getById(id);
      imaging =
              imaging.toBuilder()
                      .ecg(fullChartDTO.getEcg())
                      .otherIMG(fullChartDTO.getOtherIMG())
                      .chart(chart)
                      .build();
      imagingRepository.save(imaging);

      Plan plan = planRepository.getById(id);
      plan =
              plan.toBuilder()
                      .anestheticPlan(fullChartDTO.getAnestheticPlan())
                      .anestheticWorkup(fullChartDTO.getAnestheticWorkup())
                      .chart(chart)
                      .build();
      planRepository.save(plan);
    }
  }

  // makes a check if entity is present and deletes it if it is not null
  @Transactional
  public void deleteChart(UUID uuid) {
    Optional<Chart> chartOptional = chartRepository.findByUuid(uuid);
    Long id = chartOptional.get().getId();
    assesmentRepository.deleteById(id);
    imagingRepository.deleteById(id);
    labResRepository.deleteById(id);
    planRepository.deleteById(id);
    vitalRepository.deleteById(id);
    chartRepository.deleteById(id);
//    Chart chart = chartOptional.get();
//    chartRepository.delete(chart);
//    chartOptional.ifPresent(chartRepository::delete);
  }
}
