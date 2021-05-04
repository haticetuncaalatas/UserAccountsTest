package UserAccounts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {

		return args -> {
			 //log.info("Preloading " + repository.save(new User((long) 1, "Hatice", (long) 1234567890, "hatice.tunca_alatas@nokia.com", "", "Portugal", "PT01")));
			 //log.info("Preloading " + repository.save(new User((long) 2, "TestUser", (long) 1234567899, "testuser@nokia.com", "", "Turkey", "PT01" )));
		};
	}
}
