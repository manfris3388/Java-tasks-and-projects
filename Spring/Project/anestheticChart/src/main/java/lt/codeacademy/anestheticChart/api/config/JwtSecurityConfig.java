package lt.codeacademy.anestheticChart.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.filter.JwtAuthenticationFilter;
import lt.codeacademy.anestheticChart.mvc.user.service.UserService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@Profile("rest")
@RequiredArgsConstructor
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    private final ObjectMapper objectMapper;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable();
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        http = http
                .authorizeRequests()
                .antMatchers(
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/v2/api-docs/**",  // if we want to use old swagger version
                        "/v3/api-docs/**"
                ).permitAll()
                .anyRequest()
                .authenticated()
                .and();
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and();
        http
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), objectMapper, userService));
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
