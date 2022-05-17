package lt.codeacademy.anestheticChart.repository;

import lombok.Getter;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class ChartRepository {

    private final List<ChartDTO> charts = new ArrayList<>();

    public void save(ChartDTO chart){
        charts.add(chart);
    }
}
