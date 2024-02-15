package com.Inventrik.ProjectCrud.employeeDirectory.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	
	
	@Bean
	
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve a user by username 
		
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id,pw,active from members where user_id=?"	);
		
		//define query to retrieve the authority/roles by username
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				
				"select user_id,role from roles where user_id=?" );
		return jdbcUserDetailsManager;
	}

   
    @Bean
    public SecurityFilterChain filerChain (HttpSecurity http) throws Exception{  
    	http.authorizeHttpRequests(configurer ->
    		configurer
    		.requestMatchers(HttpMethod.GET,"/employees").hasRole("EMPLOYEE")
    		.requestMatchers(HttpMethod.GET,"/employee/**").hasRole("EMPLOYEE")
    		.requestMatchers(HttpMethod.POST,"/employee").hasRole("MANAGER")
    		.requestMatchers(HttpMethod.PUT,"/employee").hasRole("MANAGER")
    		.requestMatchers(HttpMethod.DELETE,"/employee/**").hasRole("ADMIN")
    		
    			);
    	
    	//USE HTTP BASIC authentication
    	
    	http.httpBasic();
    	
    	//disable cross site request Forgery (CSRF)
    	//in general, not required for stateless REST APIs that use POST,PUT,DELETE and/or PATCH
    	
    	http.csrf().disable();
    	
    	return http.build();
    }
    
    
    
    
    
    /* @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
        						.username("john")
                                .password("{noop}test123")
                                .roles("EMPLOYEE")
                                .build();

        UserDetails mary = User.builder()
								.username("mary")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER")
                                .build();

        UserDetails susan = User.builder()
								.username("susan")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    } */
}


























