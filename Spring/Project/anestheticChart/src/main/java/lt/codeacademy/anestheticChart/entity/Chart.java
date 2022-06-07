package lt.codeacademy.anestheticChart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "charts")
public class Chart {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
    private String operation;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Vitals vitals;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private LabRes labRes;

    @OneToOne(mappedBy = "chart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Assesment assesment;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Imaging imaging;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Plan plan;
}
