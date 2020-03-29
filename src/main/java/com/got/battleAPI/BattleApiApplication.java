package com.got.battleAPI;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BattleApiApplication {

	@Bean()
	public Mapper dozerBean() {

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		return dozerBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(BattleApiApplication.class, args);
	}

}
