package com.shop.Shop.API;

import org.modelmapper.AbstractCondition;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
public class ShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApiApplication.class, args);
	}



}
