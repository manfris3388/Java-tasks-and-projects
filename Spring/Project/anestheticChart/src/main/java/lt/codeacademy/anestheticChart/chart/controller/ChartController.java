package lt.codeacademy.anestheticChart.chart.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.dto.ChartDTO;
import lt.codeacademy.anestheticChart.service.ChartService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chart")
public class ChartController {

    private final ChartService chartService;


    //connects ChartDTO to anaestheticChart.html. Also assigns parameters to thymeleaf through Model creating Thymeleaf object.
    @GetMapping
    public String openAnestheticForm(Model model){
        model.addAttribute("chart", ChartDTO.builder().build());
        return "anestheticChart";
    }

    //post data from /chart/open from Thymeleaf. Initializes ChartDTO fields. Goes to service and then to repository to write data in memory
    //adding message after successful commit
    @PostMapping
    public String createAnestheticChart(Model model, ChartDTO chartDTO){
        chartService.addChart(chartDTO);
        model.addAttribute("chart", ChartDTO.builder().build());
        model.addAttribute("message", "Anesthetic chart added successfully");
        return "anestheticChart";
    }

    //gets data from memory. Sets up another Thymeleaf object. Connects URL to html template and Model Java to Thymeleaf to HTML.
    @GetMapping("/list")
    public String getCharts(Model model, Pageable pageable){
        model.addAttribute("patientsDemographics", chartService.getChartsPaginated(pageable));
        return "anestheticCharts";
    }

    //get's anesthetic chart data from db using UUID and fills anesthetic chart template with it
    @GetMapping("/update")
    public String getChartUpdateWindow(Model model, @RequestParam UUID uuid){
        model.addAttribute("chart", chartService.getChartByUUID(uuid));
        return "anestheticChart";
    }

    @PostMapping("/update")
    public String updateChart(Model model, ChartDTO chartDTO){
        chartService.updateChart(chartDTO);
        model.addAttribute("patientsDemographics", chartService.getCharts());
        return "anestheticCharts";
    }

    @GetMapping("/delete")
    public String deleteChart(Model model, @RequestParam UUID uuid){
        chartService.deleteChart(uuid);
        model.addAttribute("patientsDemographics", chartService.getCharts());
        return "anestheticCharts";
    }
}
