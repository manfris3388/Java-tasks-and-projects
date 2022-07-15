package lt.codeacademy.anestheticChart.jpa.entity.chart_mvc;

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
    private Long chartId;
    private String ecg;

    @Column(name = "other_img")
    private String otherIMG;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "chart_id")
    private Chart chart;
}
