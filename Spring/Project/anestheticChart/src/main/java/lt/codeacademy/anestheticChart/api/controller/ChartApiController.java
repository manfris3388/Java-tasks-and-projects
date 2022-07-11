package lt.codeacademy.anestheticChart.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.dto.ChartsResponse;
import lt.codeacademy.anestheticChart.mvc.chart.service.ChartService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/charts")
@Api(tags = "Chart Controller")
public class ChartApiController {

    private final ChartService chartService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(
            value = "Get all charts",
            notes = "Get all charts from db and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grąžina anestezijos lapus"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant anestezijos lapų sarasą"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisių gauti produktų sarasą")
    })
    public ChartsResponse getCharts() {
        return ChartsResponse.builder().charts(chartService.getCharts()).build();
    }
}
