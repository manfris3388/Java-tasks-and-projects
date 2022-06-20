package lt.codeacademy.anestheticChart;

public interface ChartEndPoints {

    String CHART_ROOT_PATH = "/user/chart";
    String PAGE_ROOT_PATH = CHART_ROOT_PATH + "/page";
    String UPDATE_ROOT_PATH = CHART_ROOT_PATH + "/update";
    String DELETE_ROOT_PATH = CHART_ROOT_PATH + "/delete";
    String USER_ROOT_PATH = "/user/users";
    String REGISTER_ROOT_PATH = USER_ROOT_PATH + "/register";
    String FINDER_ROOT_PATH = PAGE_ROOT_PATH + "/chart-finder";
}
