package lt.codeacademy.anestheticChart.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.anestheticChart.api.dto.ChartsResponse;
import lt.codeacademy.anestheticChart.mvc.chart.dto.FullChartDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RequestMapping(ChartApiController.CHARTS_ROOT_PATH)
@Api(tags = "Chart Controller")
public interface ChartApiSpecs {
  String CHARTS_ROOT_PATH = "/api/charts";
  String UUID_PATH = "/{uuid}";

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(
      value = "Get all charts",
      notes = "Get all charts from db, and any other information could be here")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Kai sekmingai grazina anestezijos lapus"),
        @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant anestezijos lapus"),
        @ApiResponse(
            code = 403,
            message = "Neturite reikalingu teisiu gauti anestezijos lapu sarasa")
      })
  ChartsResponse getCharts();

  @GetMapping(
      path = UUID_PATH,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "Get one chart by id")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Kai sekmingai grazina anestezijos lapa"),
        @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant anestezijos lapa"),
        @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti anestezijos lapa")
      })
  ChartsResponse getCharts(@PathVariable("uuid") UUID uuid);

  @GetMapping("/page")
  Page<FullChartDTO> getChartsPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size);

  @DeleteMapping(path = UUID_PATH)
  @ApiOperation(value = "Delete chart", httpMethod = "DELETE")
  void deleteChart(@PathVariable("uuid") UUID chartUUID);

  @PostMapping
  ResponseEntity<Void> createChart(@Valid @RequestBody FullChartDTO fullChartDTO);

  @PutMapping(UUID_PATH)
  @ApiOperation(value = "Update chart", httpMethod = "PUT")
  ResponseEntity<Void> updateChart(@Valid @RequestBody FullChartDTO fullChartDTO);
}
