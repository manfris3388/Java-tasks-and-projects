package lt.codeacademy.anestheticChart.chart.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.ChartEndPoints;
import lt.codeacademy.anestheticChart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.helper.MessageService;
import lt.codeacademy.anestheticChart.service.ChartService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ChartController implements ChartEndPoints {
    private final ChartService chartService;
    private final MessageService messageService;


    //connects FullChartDTO to anaestheticChart.html. Also assigns parameters to thymeleaf through Model creating Thymeleaf object.
    @GetMapping(CHART_ROOT_PATH)
    public String openAnestheticForm(Model model, String message){
        model.addAttribute("chart", FullChartDTO.builder().build());
        model.addAttribute("message", messageService.getMessage(message));
        return "anestheticChart";
    }

    //post data from /chart/open from Thymeleaf. Initializes FullChartDTO fields. Goes to service and then to repository to write data in memory
    //adding message after successful commit
    @PostMapping(CHART_ROOT_PATH)
    public String createAnestheticChart(Model model, FullChartDTO fullChartDTO){
        chartService.addChart(fullChartDTO);
        model.addAttribute("chart", FullChartDTO.builder().build());
        return "redirect:/user/chart?message=chart.create.message.success";
    }

    //gets data from db. Sets up another Thymeleaf object. Connects URL to html template and Model Java to Thymeleaf to HTML, uses
    //Pageable to sort charts to pages
    @GetMapping(PAGE_ROOT_PATH)
    public String getCharts(Model model, @PageableDefault(size = 3, sort = {"surname"}, direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("chartsPage", chartService.getChartsPaginated(pageable));
        return "anestheticCharts";
    }

    //gets anesthetic chart data from db using UUID and fills anesthetic chart template with it
    @GetMapping(UPDATE_ROOT_PATH)
    public String getChartUpdateWindow(Model model, @RequestParam UUID uuid){
        model.addAttribute("chart", chartService.getFullChartByUUID(uuid));
        return "anestheticChart";
    }

    //connects HTML to URL also HTML to Java. Collects data from web page, converts from DTO to Entity and updates db
    @PostMapping(UPDATE_ROOT_PATH)
    public String updateChart(Model model, FullChartDTO fullChartDTO){
        chartService.updateChart(fullChartDTO);
        return "redirect:/user/chart/page";
    }

    @GetMapping(DELETE_ROOT_PATH)
    public String deleteChart(@RequestParam UUID uuid){
        chartService.deleteChart(uuid);
        return "redirect:/user/chart/page";
    }
}
