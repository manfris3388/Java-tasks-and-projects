package lt.codeacademy.anestheticChart.mapper;

import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.entity.PatientDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class ChartMapper {
  public ChartDTO mapToChartDTO(PatientDetailsEntity patientDetailsEntity) {
    return ChartDTO.builder()
        .uuid(patientDetailsEntity.getUuid())
        .name(patientDetailsEntity.getName())
        .surname(patientDetailsEntity.getSurname())
        .hospitalNumber(patientDetailsEntity.getHospitalNumber())
        .dob(patientDetailsEntity.getDob())
        .operation(patientDetailsEntity.getOperation())
        .build();
  }
}
