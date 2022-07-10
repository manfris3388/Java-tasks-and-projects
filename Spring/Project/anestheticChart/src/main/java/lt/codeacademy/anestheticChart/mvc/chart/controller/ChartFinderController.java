package lt.codeacademy.anestheticChart.mvc.chart.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.mvc.chart.service.ChartService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static lt.codeacademy.anestheticChart.mvc.ChartEndPoints.FINDER_ROOT_PATH;

@Controller
@RequestMapping(FINDER_ROOT_PATH)
@RequiredArgsConstructor
public class ChartFinderController{
    private final ChartService chartService;

    @GetMapping
    public String getChartByName(Model model, @RequestParam String chartName) {
        return "forward:" + FINDER_ROOT_PATH + "/searchResult/" + chartName;
    }

    @GetMapping("/searchResult/{chartName}")
    public String getChartsBySurnameSearchResult(Model model, @PathVariable String chartName, @PageableDefault(size = 3, sort = {"surname"}, direction = Sort.Direction.ASC)Pageable pageable) {
        model.addAttribute("chartsPage", chartService.getChartsBySurnamePageable(chartName, pageable));
        return "anestheticCharts";
    }
}
