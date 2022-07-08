package lt.codeacademy.anestheticChart.chart.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.chart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.chart.service.ChartService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/charts")
public class ProductApiController {

    private final ChartService chartService;

    @ResponseBody
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE) // by default produces JSON MIME type
    public List<FullChartDTO> getJsonProducts() {
        return chartService.getCharts();
    }

    @ResponseBody
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE) // by default produces JSON MIME type
    public List<FullChartDTO> getXmlProducts() {
        return chartService.getCharts();
    }
}
