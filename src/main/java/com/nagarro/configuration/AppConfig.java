package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.DbConfig;
import com.nagarro.dao.Tshirtdao;
import com.nagarro.dao.Userdao;
import com.nagarro.daoimplementation.HiberConfig;
import com.nagarro.daoimplementation.TshirtdaoImp;
import com.nagarro.daoimplementation.UserdaoImp;
import com.nagarro.service.OutputPreference;
import com.nagarro.service.TshirtComparatorService;
import com.nagarro.service.TshirtService;
import com.nagarro.service.UserService;

@Configuration
@EnableScheduling
public class AppConfig {
	@Bean
	public DbConfig getDao() {
		return new HiberConfig();
	}

	@Bean
	public Userdao getUserDao() {
		return new UserdaoImp();
	}
	
	@Bean
	public Tshirtdao getTshirtDao() {
		return new TshirtdaoImp();
	}
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	
	@Bean
	public TshirtService getTshirtService() {
		return new TshirtService();
	}
	@Bean
	public OutputPreference getOutputPreference() {
		return new OutputPreference();
	}
	
	@Bean
	public TshirtComparatorService geTshirtComparatorService() {
		return new TshirtComparatorService();
	}
}
