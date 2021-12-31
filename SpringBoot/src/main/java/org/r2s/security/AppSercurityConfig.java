package org.r2s.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSercurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<UserDetails>();
//		users.add(User.withDefaultPasswordEncoder().username("r2s").password("1234").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		
		// Permit all request
		http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
				
		/** authorize
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/students/**").hasAnyRole("USER","ADMIN")
				.mvcMatchers(HttpMethod.POST, "/students").hasRole("ADMIN") 
				.anyRequest().denyAll()
		    .and().csrf().disable();
		**/
		}
	
	@Override
	@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			// TODO Auto-generated method stub
			return super.authenticationManagerBean();
		}

}
