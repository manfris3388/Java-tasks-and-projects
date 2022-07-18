package lt.codeacademy.anestheticChart.mvc.chart.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Profile("mvc")
@Component
@Slf4j
public class MyChartFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.trace("------> my chart filter implementation :::before::: do filter chain");

        chain.doFilter(request, response);

        log.trace("------> my chart filter implementation :::after::: do filter chain");

    }
}
