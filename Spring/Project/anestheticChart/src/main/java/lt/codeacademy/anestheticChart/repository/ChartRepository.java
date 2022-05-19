package lt.codeacademy.anestheticChart.repository;

import lombok.Getter;
import lt.codeacademy.anestheticChart.model.Chart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Repository
public class ChartRepository {

    private final List<Chart> charts = new ArrayList<>();

    public void save(Chart chart){
        chart.setUuid(UUID.randomUUID());
        charts.add(chart);
    }
}
