package lt.codeacademy.anestheticChart.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CHARTS")
public class ChartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
    private String operation;
    @OneToOne(mappedBy = "chartEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PatientVitalsEntity patientVitalsEntity;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "charts_vitals",
//            joinColumns =
//                    { @JoinColumn(name = "chart_id", referencedColumnName = "id") },
//            inverseJoinColumns =
//                    { @JoinColumn(name = "vitals_id", referencedColumnName = "id") })
//    PatientVitalsEntity patientVitalsEntity;
//    @ManyToMany(cascade = CascadeType.ALL)
//    private Set<PatientVitalsEntity>patientVitalsEntities;
}
