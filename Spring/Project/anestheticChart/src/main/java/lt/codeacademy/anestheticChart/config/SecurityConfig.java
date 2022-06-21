package lt.codeacademy.anestheticChart.config;

import lombok.RequiredArgsConstructor;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;


import static lt.codeacademy.anestheticChart.chart.controller.ChartController.CHART_ROOT_PATH;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  PGSimpleDataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .ignoringAntMatchers("/**")
        .and()
        .authorizeRequests()
        .antMatchers("/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll()
        .loginPage("/login-chart")
        .loginProcessingUrl("/login-chart")
        .defaultSuccessUrl(CHART_ROOT_PATH, true)
        .usernameParameter("loginEmail")
        .passwordParameter("loginPassword")
        .and()
        .logout()
        .permitAll()
        .and()
        .headers()
        .permissionsPolicy();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .requestMatchers(
            PathRequest.toStaticResources()
                .atCommonLocations()); // PathRequest.toH2Console() jei turim H2 ir nenorim
                                       // ivedineti slaptazodzio
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user@chart.lt")
        .password(
            "{bcrypt}$2a$10$teqiNl4bRoRUxgrJH15ixulqUtfHsHyQMHmB62x1AGRtXyOcMJTv.") // pass is user
        .roles("USER")
        .and()
        .withUser("admin@chart.lt")
        .password(
            "{bcrypt}$2a$10$teqiNl4bRoRUxgrJH15ixulqUtfHsHyQMHmB62x1AGRtXyOcMJTv.") // pass is user
        .roles("USER", "ADMIN")
        .and()
        .withUser("no-bcrypt@chart.lt")
        .password("{noop}a") // password without encoding, as plain text
        .roles("USER", "ADMIN")
        .and()
        .and()
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
            "SELECT email AS username, password, TRUE AS enabled FROM users WHERE email = ?")
        .authoritiesByUsernameQuery(
            "SELECT email AS username, 'USER' AS authority FROM users WHERE email = ?")
        .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
  }
}
