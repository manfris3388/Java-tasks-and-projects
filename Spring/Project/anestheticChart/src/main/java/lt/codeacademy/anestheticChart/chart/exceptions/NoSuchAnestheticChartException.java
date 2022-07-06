package lt.codeacademy.anestheticChart.chart.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class NoSuchAnestheticChartException extends RuntimeException {
    private final UUID chartId;
}
