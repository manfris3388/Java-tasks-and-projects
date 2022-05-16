package lt.codeacademy.anestheticChart.chart.controller;


import lt.codeacademy.anestheticChart.model.ChartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WriteChartController {

    @GetMapping("/writeChart")
    public String openAnestheticForm(Model model){
        model.addAttribute("chartDTO", new ChartDTO());
        return "anestheticChart";
    }

    @PostMapping("/writeChart")
    public String createAnestheticChart(Model model, ChartDTO chart){
        return "anestheticChart";
    }
}
