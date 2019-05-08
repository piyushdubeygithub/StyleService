package com.prosmv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.prosmv.constants.url.ApiUrl;
import com.prosmv.filter.TokenAuthenticationFilter;
import com.prosmv.repositories.AuthenticationTokenRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	@Autowired//
//	UserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
//	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//     List<UserDetails> users = new ArrayList<>();
//     users.add(User.withDefaultPasswordEncoder().username("piyush").password("12345").roles("USER").build());
//	 return new InMemoryUserDetailsManager(users);
//	}

	   @Autowired
	    private AuthenticationTokenRepository authenticationTokenRepository;
	  
	    @Override
	    protected void configure(final HttpSecurity http) throws Exception
	    {

	        //Implementing Token based authentication in this filter
	    	http.csrf().disable().
			sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    	http.authorizeRequests().antMatchers(HttpMethod.POST,ApiUrl.LOGIN_URL).permitAll()
			.antMatchers(HttpMethod.GET,ApiUrl.GET_USER_CUSTOMERS).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.REGISTER_CUSTOMER).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.UPDATE_CUSTOMER).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.ADD_BRAND).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.GET_ALL_BRANDS).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.DELETE_BRAND).hasRole("USER").anyRequest().authenticated()
			.antMatchers(HttpMethod.GET,ApiUrl.DELETE_CUSTOMER).hasRole("USER").anyRequest().authenticated();
	    	http.authorizeRequests().antMatchers(ApiUrl.GET_SIZE_BY_GRID_SIZE).authenticated();
	    	http.authorizeRequests().antMatchers(ApiUrl.GET_SIZE_GRID_BY_FACTORY).authenticated();
	    	http.authorizeRequests().antMatchers(ApiUrl.GET_RANGE_BY_FACTORY).authenticated();
	    	http.authorizeRequests().antMatchers(ApiUrl.GET_CATEGORY_BY_FACTORY).authenticated();
			// Implementing Token based authentication in this filter
		   final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter(authenticationTokenRepository);
		  http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);
		}
	    
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	    	web.ignoring().antMatchers("/v2/api-docs/**");
	    	web.ignoring().antMatchers("/swagger.json");
	    	web.ignoring().antMatchers("/swagger-ui.html");
	    	web.ignoring().antMatchers("/webjars/**");
	    	web.ignoring().antMatchers("/swagger-resources/**");
	    }

}
