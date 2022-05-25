package lt.codeacademy.anestheticChart.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.Chart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Getter
@Repository
public class ChartRepository {

  private final Map<UUID, Chart> charts;

  private final JdbcTemplate jdbcTemplate;

  ChartRepository(JdbcTemplate jdbcTemplate){
      this.jdbcTemplate = jdbcTemplate;
      this.charts = new HashMap<>();
  }

  public void save(Chart chart) {
    UUID uuid = UUID.randomUUID();
    chart.setUuid(uuid);
    charts.put(uuid, chart);
  }

  public List<Chart> getCharts() {
    return jdbcTemplate.query(
        "SELECT * FROM ANESTHETIC_CHARTS",
        new RowMapper<Chart>() {
          @Override
          public Chart mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Chart.builder()
                .uuid(UUID.fromString(rs.getString("uuid")))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .hospitalNumber(rs.getString("hospital_number"))
                .dob(rs.getString("dob"))
                .operation(rs.getString("operation"))
                .build();
          }
        });
  }

  public Chart getChartByUUID(UUID uuid) {
    return charts.get(uuid);
  }

  public void updateChart(Chart chart) {
    charts.put(chart.getUuid(), chart);
  }

  public void deleteChart(UUID uuid) {
    charts.remove(uuid);
  }
}
