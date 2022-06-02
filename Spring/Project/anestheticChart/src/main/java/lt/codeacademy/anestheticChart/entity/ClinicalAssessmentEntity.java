package lt.codeacademy.anestheticChart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLINICAL_ASSESSMENT")
public class ClinicalAssessmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String pmh;
    private String dh;
    private String airwayAssessment;
    private String anestheticAssessment;
}
