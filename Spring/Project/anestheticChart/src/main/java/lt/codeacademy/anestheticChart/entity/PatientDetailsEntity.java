package lt.codeacademy.anestheticChart.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PATIENTS_DETAILS")
public class PatientDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
    private String operation;
}
