package lt.codeacademy.anestheticChart;

import lt.codeacademy.anestheticChart.chart.exceptions.NoSuchAnestheticChartException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NoSuchAnestheticChartException.class)
    public String chartNotFound(NoSuchAnestheticChartException e, Model model) {
        model.addAttribute("chartId", e.getChartId());
        return "error/chartNotFound";
    }
}
