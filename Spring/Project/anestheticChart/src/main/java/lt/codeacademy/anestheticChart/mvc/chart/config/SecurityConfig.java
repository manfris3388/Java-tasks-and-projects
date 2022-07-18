package lt.codeacademy.anestheticChart.mvc.chart.config;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.mvc.ChartEndPoints;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Profile("mvc")
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .ignoringAntMatchers()
        .and()
        .authorizeRequests()
        .antMatchers( "/")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll()
        .loginPage("/login-chart")
        .loginProcessingUrl("/login-chart")
        .defaultSuccessUrl(ChartEndPoints.CHART_ROOT_PATH, true)
        .usernameParameter("loginEmail")
        .passwordParameter("loginPassword")
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login-chart")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
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
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
