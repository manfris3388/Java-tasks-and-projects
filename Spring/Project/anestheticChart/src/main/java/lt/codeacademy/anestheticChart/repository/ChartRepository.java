package lt.codeacademy.anestheticChart.repository;

import lombok.Getter;
import lt.codeacademy.anestheticChart.model.Chart;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter
@Repository
public class ChartRepository {

    private final Map<UUID, Chart> charts = new HashMap<>();

    public void save(Chart chart){
        UUID uuid = UUID.randomUUID();
        chart.setUuid(uuid);
        charts.put(uuid, chart);
    }

    public List<Chart> getCharts(){
        return new ArrayList<>(charts.values());
    }

    public Chart getChartByUUID(UUID uuid) {
        return charts.get(uuid);
    }
}
