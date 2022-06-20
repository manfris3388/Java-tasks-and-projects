package lt.codeacademy.anestheticChart.advice;

import lt.codeacademy.anestheticChart.ChartEndPoints;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeAdvice implements ChartEndPoints {

  @ModelAttribute("chartPath")
  public String chartEndPoint() {
    return CHART_ROOT_PATH;
  }

  @ModelAttribute("pagePath")
  public String pageEndPoint() {
    return PAGE_ROOT_PATH;
  }

  @ModelAttribute("registerPath")
  public String registerEndPoint() {
    return REGISTER_ROOT_PATH;
  }

  @ModelAttribute("updatePath")
  public String updateEndPoint() {
    return UPDATE_ROOT_PATH;
  }

  @ModelAttribute("deletePath")
  public String deleteEndPoint() {
    return DELETE_ROOT_PATH;
  }

  @ModelAttribute("findPath")
  public String findEndPoint() {
    return FINDER_ROOT_PATH;
  }
}
