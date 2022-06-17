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
}
