package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.domain.Fruta;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s04.t02.n03.S04T02N03CastilloCorporanAlberto.model.repository.FrutaRepository;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/")
public class FrutaController {

	@Autowired
	private FrutaRepository repositorio;

	@PostMapping("/fruta/add")
	public ResponseEntity<?> addFruta(@RequestBody Fruta fruta) {
		Map<String, Object> respuesta = new HashMap<>();

		try {
			repositorio.save(fruta);
			respuesta.put("Creado con exito", fruta);

		} catch (DataAccessException e) {
			e.getMessage();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);

	}

	@GetMapping("/fruta/getAll")
	@ResponseBody
	public List<Fruta> getAll() {
		return repositorio.findAll();

	}

	@DeleteMapping("/fruta/delete/{id}")

	public ResponseEntity<?> deleteFruta(@PathVariable String id) {

		Map<String, Object> respuesta = new HashMap<>();
		boolean encontrado = false;
		try {
			encontrado = true;
			respuesta.put("Eliminado con exito", repositorio.findById(id).get());
			repositorio.deleteById(id);

		} catch (DataAccessException e) {

			e.getMessage();

		}

		if (encontrado) {
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/fruta/getOne/{id}")
	@ResponseBody
	public ResponseEntity<?> getOne(@PathVariable String id) {
		Fruta fruta = null;

		Map<String, Object> respuesta = new HashMap<>();

		try {

			fruta = repositorio.findById(id).get();
			respuesta.put("Encontrado", fruta);

		} catch (DataAccessException e) {

			respuesta.put("Error" + "No existe fruta con ese Id", e.getMessage());

		}

		if (fruta == null) {
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		}
	}

	@PutMapping("/fruta/update/{id}")
	public ResponseEntity<?> update(@RequestBody Fruta fruta, @PathVariable String id) {
		Fruta frutaActual = repositorio.findById(id).get();
		Fruta frutaUpdate = null;
		Map<String, Object> respuesta = new HashMap<>();

		if (frutaActual != null) {

			try {
				frutaActual.setNombre(fruta.getNombre());
				frutaActual.setCantidadQuilos(fruta.getCantidadQuilos());
				frutaUpdate = repositorio.save(frutaActual);

			} catch (DataAccessException e) {
				respuesta.put("mensaje", "Error de inserción ");
				respuesta.put("Error", e.getMessage());
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			respuesta.put("Mensaje", "Update realizado con exito");
			respuesta.put("Fruta", frutaUpdate);

			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);

		} else {
			respuesta.put("Error", "No existe");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);

		}
	}
}