package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.domain.Fruta;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.repository.FrutaRepository;

public class FrutaServiceDB implements FrutaService{
	
   @Autowired
   private FrutaRepository frutaRepositorioImpl;
	

	
		@Override
		public Fruta add(Fruta f) {
			
			return frutaRepositorioImpl.save(f);
		}

		@Override
		public List<Fruta> getAll() {
			
			return  (List<Fruta>) frutaRepositorioImpl.findAll();
		}

		

		@Override
		public Fruta update(Fruta f) {
		
			return frutaRepositorioImpl.save(f);
		}

		@Override
		public void delete(String id) {
			 frutaRepositorioImpl.deleteById(id);
		}

		

		@Override
		public Fruta getOne(String id) {
			
			return frutaRepositorioImpl.findById(id).orElse(null);
		}

}
