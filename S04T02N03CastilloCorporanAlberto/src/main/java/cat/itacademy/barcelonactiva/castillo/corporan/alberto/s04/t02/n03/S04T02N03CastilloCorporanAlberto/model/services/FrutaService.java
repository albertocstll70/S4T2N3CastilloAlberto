package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.domain.Fruta;

public interface FrutaService {
	Fruta add(Fruta f);
	List<Fruta> getAll();
	Fruta getOne(String id);
	void delete(String id);
	Fruta update(Fruta f);

}
