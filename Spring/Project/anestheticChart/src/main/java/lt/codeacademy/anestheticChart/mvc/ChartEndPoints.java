package lt.codeacademy.anestheticChart.mvc;

public interface ChartEndPoints {

    String CHART_ROOT_PATH = "/user/chart";
    String PAGE_ROOT_PATH = CHART_ROOT_PATH + "/page";
    String UPDATE_ROOT_PATH = CHART_ROOT_PATH + "/update";
    String DELETE_ROOT_PATH = CHART_ROOT_PATH + "/delete";
    String LOGIN_ROOT_PATH = "/login-chart";
    String REGISTER_ROOT_PATH = "/register";
    String FINDER_ROOT_PATH = PAGE_ROOT_PATH + "/chart-finder";
}
