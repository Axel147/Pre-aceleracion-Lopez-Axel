package com.disney.service;

import java.util.List;

import com.disney.dto.MetrajeDTO;
import com.disney.dto.MetrajeDetalleDTO;
import com.disney.dto.MetrajeImaTitFecDTO;
import com.disney.model.Metraje;

public interface IMetrajeService {
	
	public MetrajeDetalleDTO obtenerMetraje(Long id);
	
	public List<MetrajeImaTitFecDTO> obtenerMetrajes();
	
	public Metraje insertarMetraje(MetrajeDTO metrajeDTO);
	
	public Metraje actualizarMetraje(Long id,MetrajeDTO metrajeDTO);
	
	public void eliminarMetraje(Long id);

}
