package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.controller.APIController;
import com.indra.iquality.dao.DescripcionIndicadorDAO;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.singleton.Entorno;

public class DescripcionIndicadorDAOJDBCTemplateImpl implements DescripcionIndicadorDAO {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DescripcionIndicadorDAOJDBCTemplateImpl.class);
	private CustomHelper helper = new CustomHelper();
	private DataSource dataSource;
	Entorno sistema = Entorno.getInstance();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private class Certificacion{
		private int idComponente;
		private String nombre;
		private String descripcion;
		public int getIdComponente() {
			return idComponente;
		}
		public void setIdComponente(int idComponente) {
			this.idComponente = idComponente;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}
	
	@Override
	public DescripcionIndicador getById(String compRowID, String ctRowID) {

		String queryBasicosYEntidad = "SELECT"
				+ " VSMT.id_componente,"
				+ " VSMT.de_nombre as nombre, RESP.de_area as responsable, VSMT.de_definicion as definicion,"
				+ " VSMT.de_comentario as comentario, VSMT.de_historico as historico,"
				+ " VSMT.de_formula_usuario as mtd_obtencion, VSMT.de_unidad_medida as unidad_medida,"
				+ " PERACU.de_periodo_acum as periodo_acumulado"
				+ " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA VSMT, LK_MET_FI_AREA RESP, LK_MET_FI_PERIODO_ACUM PERACU"
				+ " WHERE VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ? AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = RESP.id_software and VSMT.id_sistema = RESP.id_sistema"
				+ " AND VSMT.id_area = RESP.id_area AND VSMT.id_software = PERACU.id_software"
				+ " AND VSMT.id_sistema = PERACU.id_sistema and VSMT.id_periodo_acum = PERACU.id_periodo_acum";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionIndicador di = jdbcTemplate.queryForObject(queryBasicosYEntidad, 
				new Object[]{compRowID, ctRowID, sistema.getIdSistema(), sistema.getIdSoftware()}, new RowMapper<DescripcionIndicador>(){

			@Override
			public DescripcionIndicador mapRow(ResultSet rs, int rowNum) throws SQLException {

				DescripcionIndicador di = new DescripcionIndicador();

				di.setId(rs.getInt("id_componente"));
				di.setNombre(helper.filterString(rs.getString("nombre")));
				di.setResponsable(helper.filterString(rs.getString("responsable")));
				di.setDefinicion(helper.filterString(rs.getString("definicion")));
				di.setComentarios(helper.filterString(rs.getString("comentario")));
				di.setHistorico(helper.filterString(rs.getString("historico")));
				di.setMetodoObtencion(helper.filterString(rs.getString("mtd_obtencion")));
				di.setUnidadMedida(helper.filterString(rs.getString("unidad_medida")));
				di.setPeriodoAcumulado(helper.filterString(rs.getString("periodo_acumulado")));

				return di;
			}
		});

		logger.debug(("[getById] : Obtenidos datos mínimos del indicador -> " + di.toString()));
		System.out.println("[getById] : Obtenidos datos mínimos del indicador -> " + di.toString());
		// Busco las certificaciones del indicador
		List<Certificacion> certificaciones = getCertificaciones(di.getId());
		List<String> descripcionCertificaciones = new ArrayList<String>();
		for(Certificacion c : certificaciones) {
			descripcionCertificaciones.add(c.getDescripcion());
		}
		di.setCertificaciones(descripcionCertificaciones);
		
		logger.debug(("[getById] : Obtenidos todos los datos del indicador -> " + di.toString()));
		System.out.println("[getById] : Obtenidos todos los datos del indicador -> " + di.toString());
		return di;
	}
	
	private List<Certificacion> getCertificaciones(int idComponente) {

		String queryBasicosYEntidad = "SELECT" 
				+ " COMP.ID_COMPONENTE,"
				+ " COMP.DE_NOMBRE,"
				+ " CERT.DE_CERTIFICACION"
				+ " FROM LK_MET_FI_CERTIFICACION CERT"
				+ " LEFT JOIN LK_MET_FI_COMPONENTE COMP"
				+ " ON(COMP.ID_COMPONENTE = CERT.ID_COMPONENTE_HIJO AND"
				+ " COMP.ID_SOFTWARE = CERT.ID_SOFTWARE AND"
				+ " COMP.ID_SISTEMA = CERT.ID_SISTEMA)"
				+ " WHERE" 
				+ " COMP.ID_COMPONENTE = ? AND"
				+ " COMP.ID_SISTEMA = ? AND"
				+ " COMP.ID_SOFTWARE = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Certificacion> certList = new ArrayList<Certificacion>();
		List<Map<String,Object>> certRows= jdbcTemplate.queryForList(queryBasicosYEntidad, 
				new Object[]{idComponente, sistema.getIdSistema(), sistema.getIdSoftware()});
		
		for(Map<String, Object> certRow : certRows){

			Certificacion cert = new Certificacion();
			
			if (certRow.get("id_componente") != null)
				cert.setIdComponente(Integer.valueOf((String.valueOf(certRow.get("id_componente")))));
			else cert.setIdComponente(Entorno.DEFAULT_NULL_INT);
			
			if (certRow.get("de_nombre") != null)
				cert.setNombre((String.valueOf(certRow.get("de_nombre"))));
			else cert.setNombre(Entorno.DEFAULT_NULL_STRING);
			
			if (certRow.get("de_certificacion") != null)
				cert.setDescripcion((String.valueOf(certRow.get("de_certificacion"))));
			else cert.setDescripcion(Entorno.DEFAULT_NULL_STRING);
		
			certList.add(cert);
		}
		
		logger.debug(("[getById] : Obtenidas las certificaciones del indicador -> " + certList.toString()));
		System.out.println("[getById] : Obtenidas las certificaciones del indicador -> " + certList.toString());
		return certList;
	}
}
