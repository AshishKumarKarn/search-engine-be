package com.search.searchenginebe;

import com.search.searchenginebe.dao.Item;
import com.search.searchenginebe.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class SearchEngineBeApplication {

	private static final Logger log = LoggerFactory.getLogger(SearchEngineBeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineBeApplication.class, args);
	}








	@Bean
	public CommandLineRunner demo(ItemRepository repository) {
		return (args) -> {
			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			int targetStringLengthForRelatedContent = 30;
			// save a few items
			for(long i=0;i<10000;i++){



				String generatedStringForItemName = new Random().ints(leftLimit, rightLimit + 1)
						.limit(targetStringLength)
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
						.toString();
				String generatedStringForRelatedContent  = new Random().ints(leftLimit, rightLimit + 1)
						.limit(targetStringLengthForRelatedContent)
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
						.toString();
				System.out.println(generatedStringForItemName);
				repository.save(new Item(i,generatedStringForItemName,generatedStringForRelatedContent));
			}

			// fetch all items
			log.info("Items found with findAll():");
			log.info("-------------------------------");
			for (Item item : repository.findAll()) {
				log.info(item.toString());
			}
			log.info("");

			// fetch an individual items by ID
			Optional<Item> optionalItem = repository.findById(1L);
			log.info("Items found with findById(1L):");
			log.info("--------------------------------");
			log.info(optionalItem.get().toString());
			log.info("");

			// fetch Items by last name
			log.info("Items found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findAllByItemNameLike("k", Sort.by("itemName")).forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}
}
