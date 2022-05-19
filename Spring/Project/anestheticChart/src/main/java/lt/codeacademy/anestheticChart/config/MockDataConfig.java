package lt.codeacademy.anestheticChart.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.anestheticChart.model.Chart;
import lt.codeacademy.anestheticChart.repository.ChartRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class MockDataConfig {

  private static final int MAX_COUNT = 10;

  private final ChartRepository chartRepository;

  @Bean
  public void initCharts() {
    var count = 0;
    while (MAX_COUNT >= count) {
      chartRepository.save(
          Chart.builder()
              .name("Jonas" + count)
              .surname("Jonaitis" + count * 2)
              .hospitalNumber("D54698" + count)
              .dob("1972-04-" + (count*2+1))
              .build());
      count++;
    }
    // needs .yml file configuration logging: level: (amount)::: debug
    log.atDebug().log("<=============Sukurti mock duomenys=================>");
  }
}
