package lt.codeacademy.anestheticChart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IMAGING")
public class ImagingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ecg;
    private String otherIMG;
    private String anestheticPlan;
    private String anestheticWorkup;
}
