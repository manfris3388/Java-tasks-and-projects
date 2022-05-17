package lt.codeacademy.anestheticChart.chart.controller;


import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import lt.codeacademy.anestheticChart.service.ChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class WriteChartController {

    private final ChartService chartService;

    @GetMapping("/writeChart")
    public String openAnestheticForm(Model model){
        model.addAttribute("chartDTO", new ChartDTO());
        return "anestheticChart";
    }

    @PostMapping("/writeChart")
    public String createAnestheticChart(Model model, ChartDTO chart){
        chartService.addCharts(chart);
        return "anestheticChart";
    }
}
