package lt.codeacademy.anetheticChart.chart.advice;

import lt.codeacademy.anetheticChart.ChartEndPoints;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeAdvice implements ChartEndPoints {

  @ModelAttribute("chartPath")
  public String chartEndPoint() {
    return ChartEndPoints.CHART_ROOT_PATH;
  }

  @ModelAttribute("pagePath")
  public String pageEndPoint() {
    return ChartEndPoints.PAGE_ROOT_PATH;
  }

  @ModelAttribute("registerPath")
  public String registerEndPoint() {
    return ChartEndPoints.REGISTER_ROOT_PATH;
  }

  @ModelAttribute("updatePath")
  public String updateEndPoint() {
    return ChartEndPoints.UPDATE_ROOT_PATH;
  }

  @ModelAttribute("deletePath")
  public String deleteEndPoint() {
    return ChartEndPoints.DELETE_ROOT_PATH;
  }

  @ModelAttribute("findPath")
  public String findEndPoint() {
    return ChartEndPoints.FINDER_ROOT_PATH;
  }
}
