package fi.haagahelia.course;

import java.util.ArrayList;
import java.util.List;

import fi.haagahelia.course.web.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    	@Autowired
    	private UserDetailServiceImpl userDetailsService;
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
	        .and()
	        .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
	        .and()
	        .authorizeRequests().anyRequest().authenticated()
	        .and()
	      .formLogin()
<<<<<<< HEAD
	      	  .loginPage("/login")
=======
>>>>>>> 4a826cccbcc1a0912ce13e35ce8a6084fe979523
	          .defaultSuccessUrl("/bookinglist", true)
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll();
	    }


//	    @Bean
//	    @Override
//	    public UserDetailsService userDetailsService() {
//	        List<UserDetails> users = new ArrayList();
//
//	        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//	        UserDetails user = User
//	        		.withUsername("user")
//	        		.password(passwordEncoder.encode("user"))
//	        		.roles("USER")
//	        		.build();
//
//	        users.add(user);
//
//	        user = User
//	        		.withUsername("admin")
//	        		.password(passwordEncoder.encode("admin"))
//	        		.roles("USER", "ADMIN")
//	        		.build();
//
//	    	users.add(user);
//
//	        return new InMemoryUserDetailsManager(users);
//	    }

	    
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new
		BCryptPasswordEncoder());
		}

	}
