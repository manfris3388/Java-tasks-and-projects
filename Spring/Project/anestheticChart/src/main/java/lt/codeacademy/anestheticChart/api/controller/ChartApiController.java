package lt.codeacademy.anestheticChart.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.dto.ChartsResponse;
import lt.codeacademy.anestheticChart.mvc.chart.dto.FullChartDTO;
import lt.codeacademy.anestheticChart.mvc.chart.service.ChartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(ChartApiController.CHARTS_ROOT_PATH)
@Api(tags = "Chart Controller")
public class ChartApiController {
    public static final String CHARTS_ROOT_PATH = "/api/charts";
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

    @GetMapping("/page")
    public Page<FullChartDTO> getChartsPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        return chartService.getChartsPaginated(PageRequest.of(page, size));
    }

    @DeleteMapping(path = UUID_PATH)
    @ApiOperation(value = "Delete chart", httpMethod = "DELETE")
    public void deleteChart(@PathVariable("uuid") UUID chartUUID) {
        chartService.deleteChart(chartUUID);
    }

    @PostMapping
    public ResponseEntity<Void> createChart(@Valid @RequestBody FullChartDTO fullChartDTO) {

        chartService.addChart(fullChartDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @ApiOperation(value = "Update chart", httpMethod = "PUT")
    public ResponseEntity<Void> updateChart(@Valid @RequestBody FullChartDTO fullChartDTO) {
        if (chartService.updateChart(fullChartDTO)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.notFound().build();
    }
}
