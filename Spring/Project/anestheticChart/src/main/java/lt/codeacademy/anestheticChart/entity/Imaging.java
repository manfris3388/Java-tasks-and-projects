package lt.codeacademy.anestheticChart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Imaging {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "chart_id")
    private Long id;
    private String ecg;
    @Column(name = "other_img")
    private String otherIMG;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Chart chart;
//    @OneToOne(mappedBy = "imaging")
//    @MapsId
////    @JoinColumn(name = "chart_id")
//    private Chart chart;
}
