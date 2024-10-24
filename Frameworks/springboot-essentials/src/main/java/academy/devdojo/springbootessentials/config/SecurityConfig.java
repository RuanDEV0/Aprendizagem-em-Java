package academy.devdojo.springbootessentials.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable() // Caso você não esteja usando CSRF
				.authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
				.httpBasic(httpSecurityHttpBasicConfigurer -> {}); // Habilita o login com formulário, se necessário
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user = User.builder()
				.username("william")
				.password(passwordEncoder.encode("academy")) // Usa o PasswordEncoder
				.roles("USER", "ADMIN")
				.build();

		UserDetails userTwo = User.builder()
				.username("devdojo")
				.password(passwordEncoder.encode("academy")) // Usa o PasswordEncoder
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user, userTwo);
	}
}
