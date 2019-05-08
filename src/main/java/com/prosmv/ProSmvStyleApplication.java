package com.prosmv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProSmvStyleApplication {
	 private static final Logger LOGGER = LogManager.getLogger(ProSmvStyleApplication.class);
	public static void main(String[] args) {
		LOGGER.info("application started");
		//List<Seasons> seasons = new ArrayList<>(EnumSet.allOf(Seasons.class));
//		List<SizeGrid> sizeGrids = new ArrayList<>(EnumSet.allOf(SizeGrid.class));
//		for(SizeGrid sizeGrid: sizeGrids) {
//			LOGGER.info(sizeGrid.getKey()+" "+sizeGrid.getValue());
//		}

		SpringApplication.run(ProSmvStyleApplication.class, args);
	}
}
