package lt.codeacademy.anestheticChart.repository;

import lombok.Getter;
import lt.codeacademy.anestheticChart.model.Chart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class ChartRepository {

    private final List<Chart> charts = new ArrayList<>();

    public void save(Chart chart){
        charts.add(chart);
    }
}
