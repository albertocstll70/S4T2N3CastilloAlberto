package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Document(collection="Frutas")
public class Fruta {
	
	@Id	
	private String id;	
	
	private String nombre;	
	
	private double cantidadQuilos;
	
	
public Fruta() {
	
}
	
	public Fruta(String nombre, double cantidadQuilos) {
	
		this.nombre = nombre;
		this.cantidadQuilos = cantidadQuilos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidadQuilos() {
		return cantidadQuilos;
	}

	public void setCantidadQuilos(double cantidadQuilos) {
		this.cantidadQuilos = cantidadQuilos;
	}
	

	
}