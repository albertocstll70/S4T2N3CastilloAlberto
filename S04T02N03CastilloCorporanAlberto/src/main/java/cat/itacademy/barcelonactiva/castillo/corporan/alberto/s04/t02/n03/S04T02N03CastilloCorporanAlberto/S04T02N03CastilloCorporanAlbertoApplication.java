package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.repository.FrutaRepository;
@Component
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

@EnableMongoRepositories(basePackageClasses = FrutaRepository.class)
public class S04T02N03CastilloCorporanAlbertoApplication   {

	
	public static void main(String[] args) {
		SpringApplication.run(S04T02N03CastilloCorporanAlbertoApplication.class, args);
	}

}
