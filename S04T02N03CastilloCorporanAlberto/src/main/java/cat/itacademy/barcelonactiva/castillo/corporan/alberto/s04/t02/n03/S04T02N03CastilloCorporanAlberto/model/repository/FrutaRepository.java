package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.domain.Fruta;

@EnableMongoRepositories
public interface FrutaRepository extends MongoRepository<Fruta,String>{

	//List<Fruta> buscarNombre(String titulo);
	
}
