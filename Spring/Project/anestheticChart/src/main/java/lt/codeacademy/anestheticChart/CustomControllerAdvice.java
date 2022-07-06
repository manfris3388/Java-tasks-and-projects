package lt.codeacademy.anestheticChart;

import lt.codeacademy.anestheticChart.chart.exceptions.NoSuchAnestheticChartException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NoSuchAnestheticChartException.class)
    public String chartNotFound(NoSuchAnestheticChartException e, Model model) {
        model.addAttribute("chartId", e.getChartId());
        return "error/chartNotFound";
    }

    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }
}
