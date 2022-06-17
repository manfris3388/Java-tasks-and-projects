package lt.codeacademy.anestheticChart.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static lt.codeacademy.anestheticChart.chart.controller.ChartController.CHART_ROOT_PATH;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .permitAll()
                .loginPage("/login-chart")
                .loginProcessingUrl("/login-chart")
                .defaultSuccessUrl(CHART_ROOT_PATH, true)
                .usernameParameter("loginEmail")
                .passwordParameter("loginPassword");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations()); //PathRequest.toH2Console() jei turim H2 ir nenorim ivedineti slaptazodzio
    }
}
