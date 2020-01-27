package com.devfam.miag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 
import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.services.AdminSecurityDetailsService;

@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = AdminRepository.class)
@Configuration
public class ConfigurationSecurity {
	
	@Autowired
	private AdminSecurityDetailsService adminDetService;
	

}
