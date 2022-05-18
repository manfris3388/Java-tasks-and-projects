package lt.codeacademy.anestheticChart.chart.controller;


import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.model.ChartDTO;
import lt.codeacademy.anestheticChart.service.ChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chart")
public class ChartController {

    private final ChartService chartService;

    //connects ChartDTO to anaestheticChart.html. Also assigns parameters to thymeleaf through Model creating Thymeleaf object.
    @GetMapping("")
    public String openAnestheticForm(Model model){
        model.addAttribute("chartDTO", new ChartDTO());
        return "anestheticChart";
    }

    //post data from /chart/open from Thymeleaf. Initializes ChartDTO fields. Goes to service and then to repository to write data in memory
    @PostMapping("")
    public String createAnestheticChart(Model model, ChartDTO chart){
        chartService.addCharts(chart);
        return "anestheticChart";
    }

    //gets data from memory. Sets up another Thymeleaf object. Connects to html template.
    @GetMapping("/list")
    public String getCharts(Model model){
        model.addAttribute("patientsDemographics", chartService.getCharts());
        return "anestheticCharts";
    }
}
