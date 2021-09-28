package com.disney.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeDetalleDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.model.Metraje;
import com.disney.service.IMetrajeService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MetrajeController {
	
	@Autowired
	private IMetrajeService iMetrajeService;
	
	@GetMapping("/{id}")
	public MetrajeDetalleDTO obtenerMetraje(@PathVariable("id") Long id){ //para recibir un parametro desde el cliente @PathVariable
		return iMetrajeService.obtenerMetraje(id);
	}
	
	@GetMapping
	public ResponseEntity<?> obtenerMetrajes(){
		return new ResponseEntity<>(iMetrajeService.obtenerMetrajes(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> insertarMetraje(@RequestBody MetrajeDTO metrajeDTO) {
		Metraje metraje = iMetrajeService.insertarMetraje(metrajeDTO);
		return new ResponseEntity<>(metraje, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarMetraje(@PathVariable("id") Long id, @RequestBody MetrajeDTO metrajeDTO){
		Metraje metraje = iMetrajeService.actualizarMetraje(id,metrajeDTO);//por ahora por mas que no encuentre el id pasado por parametro agrega el elemento nuevo , modificarlo
		return new ResponseEntity<>(metraje,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarMetraje(@PathVariable("id") Long id) {
		iMetrajeService.eliminarMetraje(id);
		return new ResponseEntity<>("Metraje eliminado correctamente", HttpStatus.OK);
	}
	
	/*
	@Autowired
	private IMetrajeService iMetrajeService;
	
	@GetMapping("/{id}")
	public Metraje obtenerMetraje(@PathVariable("id") Long id) { //para recibir un parametro desde el cliente @PathVariable
		return iMetrajeService.obtenerMetraje(id);
	}
	
	@GetMapping
	public List<Metraje> obtenerMetrajes(){
		 return iMetrajeService.obtenerMetrajes();
	}
	
	@PostMapping //para poder almacenar un dato en la apirest
	public Metraje insertarMetraje(@RequestBody Metraje metraje) {
		//System.out.println(metraje.getTitulo());
		iMetrajeService.insertarMetraje(metraje);
		return metraje;
	}
	@PutMapping
	public void actualizarMetraje(@RequestBody Metraje metraje) { //va a venir un objeto desde el cliente
		iMetrajeService.actualizarMetraje(metraje);
		//por ahora por mas que no encuentre el id pasado por parametro agrega el elemento nuevo , modificarlo
	}
	
	@DeleteMapping("metraje/{id}")
	public void eliminarMetraje(@PathVariable("id") Long id) {
		iMetrajeService.eliminarMetraje(id);
	}
	*/
}
