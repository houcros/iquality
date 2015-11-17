package com.indra.iquality.dao;

import java.util.List;

import com.indra.iquality.model.CertificacionDeNegocio;
import com.indra.iquality.model.DetalleDeCertificacion;

public interface CertificacionDeNegocioDAO {

	public List<CertificacionDeNegocio> getAll();
	
	public List<String> getHeadersDetalles(String idMetrica);
	
	public List<DetalleDeCertificacion> getDetallesDeCertificacion(String idMes, String idMetrica, int qttHeaders);
}
