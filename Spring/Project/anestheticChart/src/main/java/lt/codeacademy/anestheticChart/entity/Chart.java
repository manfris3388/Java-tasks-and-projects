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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
    private String operation;
    @OneToOne(mappedBy = "chart", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Vitals vitals;
    @OneToOne(mappedBy = "chart", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LabRes labRes;
    @OneToOne(mappedBy = "chart", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Assesment assesment;
    @OneToOne(mappedBy = "chart", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Imaging imaging;
}
