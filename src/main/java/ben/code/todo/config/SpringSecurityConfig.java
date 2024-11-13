package ben.code.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorise)->{
//                    authorise.requestMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN");
//                    authorise.requestMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN");
//                    authorise.requestMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN");
//                    authorise.requestMatchers(HttpMethod.GET,"/api/**").hasAnyRole("ADMIN", "USER");
//                    authorise.requestMatchers(HttpMethod.PATCH,"/api/**").hasAnyRole("ADMIN", "USER");
//                    authorise.requestMatchers(HttpMethod.GET).permitAll();
                    authorise.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails khalil = User.builder()
                .username("khalil")
                .password(passwordEncoder().encode("1995"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(khalil, admin);
    }
}
