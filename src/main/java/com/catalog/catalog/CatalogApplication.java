package com.catalog.catalog;

import com.catalog.catalog.DTO.CatalogDTO;
import com.catalog.catalog.entity.Catalog;
import com.catalog.catalog.entity.SubCategory;
import com.catalog.catalog.service.CatalogInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {


	@Autowired
	CatalogInfoService catalogInfoService;


	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);






	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Transactional
	public void run(String... args) throws Exception {
	    /*List<CatalogDTO> list= catalogInfoService.filterByPrice(600,1500);
		System.out.println(list);*/
	}

}
