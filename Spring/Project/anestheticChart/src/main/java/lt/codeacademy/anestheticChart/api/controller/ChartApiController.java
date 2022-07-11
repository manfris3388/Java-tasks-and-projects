package lt.codeacademy.anestheticChart.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.dto.ChartsResponse;
import lt.codeacademy.anestheticChart.mvc.chart.service.ChartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(ChartApiController.PRODUCTS_ROOT_PATH)
@Api(tags = "Chart Controller")
public class ChartApiController {
    public static final String PRODUCTS_ROOT_PATH = "/api/charts";
    private static final String UUID_PATH = "/api/{uuid}";

    private final ChartService chartService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(
            value = "Get all charts",
            notes = "Get all charts from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina anestezijos lapus"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant anestezijos lapus"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti anestezijos lapu sarasa")
    })
    public ChartsResponse getCharts() {
        return ChartsResponse.builder()
                .charts(chartService.getCharts())
                .build();
    }


    @GetMapping(
            path = UUID_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Get one chart by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina anestezijos lapa"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant anestezijos lapa"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti anestezijos lapa")
    })
    public ChartsResponse getCharts(@PathVariable("uuid") UUID uuid) {
        return ChartsResponse.builder()
                .charts(List.of(chartService.getFullChartByUUID(uuid)))
                .build();
    }
    @DeleteMapping(path = UUID_PATH)
    public void deleteChart(@PathVariable("uuid") UUID chartUUID) {
        chartService.deleteChart(chartUUID);
    }
}
