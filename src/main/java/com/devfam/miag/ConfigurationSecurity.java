/*
  package com.devfam.miag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.entities.Admin;

@Configuration 
@EnableWebSecurity public class ConfigurationSecurity   extends WebSecurityConfigurerAdapter {
  
  @Autowired AdminRepository adminRepo;
  
  
  @Override protected void configure(HttpSecurity http) throws Exception { //
  //TODO Auto-generated method stub
  
  http.cors(); http.csrf().disable(); htt'p.authorizeRequests()
  .antMatchers("/**") .fullyAuthenticated(). and().httpBasic();
	  http.authorizeRequests().antMatchers("***").hasRole("ADMIN");
	  
	  
	  http.authorizeRequests().antMatchers("** /operation/ **").hasRole("ADMIN");
  
  
  
  
  }
  
  @Autowired public void globalConfig(AuthenticationManagerBuilder auth) throws
  Exception {
  
  
  List<Admin> listAdmin =adminRepo.findAll(); for(Admin ad:listAdmin) {
  auth.inMemoryAuthentication().withUser(ad.getLogin()).password("{noop}"+ad.
  getPassword()).roles("ADMIN");}
  
  }
  
  
  
  
  }
 */