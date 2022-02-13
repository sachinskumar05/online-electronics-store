package com.sk.estore;

import com.sk.estore.persistence.data.Item;
import com.sk.estore.services.MongoPersistenceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Log4j2
@SpringBootApplication
public class OnlineElectronicsStoreApplication {

	@Autowired
	MongoPersistenceService mongoPersistenceService;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OnlineElectronicsStoreApplication.class, args);
		log.info(" Starting Application {} ", ctx.getId() );
		OnlineElectronicsStoreApplication app = ctx.getBean(OnlineElectronicsStoreApplication.class);
		start(app);
	}


	public static void start(OnlineElectronicsStoreApplication app){
		String id = "E001";
		if(app.mongoPersistenceService.getItemById(id).isEmpty()) {
			app.mongoPersistenceService.createItems(new Item(id, "Samsung TV", 5, 800, "Home Entertainment"));
		}
		id = "E002";
		if(app.mongoPersistenceService.getItemById(id).isEmpty()) {
			app.mongoPersistenceService.createItems(new Item(id, "IPhone 13 Pro", 2, 1800, "Mobile"));
		}
		id = "E003";
		if(app.mongoPersistenceService.getItemById(id).isEmpty()) {
			app.mongoPersistenceService.createItems(new Item(id, "Sony headphone", 2, 100, "Mobile Accessories"));
		}

		app.mongoPersistenceService.getAllItems().stream().forEach(System.out::println);
	}

}
