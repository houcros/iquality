package com.indra.iquality.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DescripcionIndicadorDAO;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.singleton.Sistema;

public class DescripcionIndicadorDAOJDBCTemplateImpl implements DescripcionIndicadorDAO {

	private DataSource dataSource;
	Sistema sistema = Sistema.getInstance();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private class Certificacion{
		private int idCertificacion;
		private int idComponente;
		private String descripcion;
		public int getIdCertificacion() {
			return idCertificacion;
		}
		public void setIdCertificacion(int idCertificacion) {
			this.idCertificacion = idCertificacion;
		}
		public int getIdComponente() {
			return idComponente;
		}
		public void setIdComponente(int idComponente) {
			this.idComponente = idComponente;
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
				di.setNombre(rs.getString("nombre"));
				di.setResponsable(rs.getString("responsable"));
				di.setDefinicion(rs.getString("definicion"));
				di.setComentarios(rs.getString("comentario"));
				di.setHistorico(rs.getString("historico"));
				di.setMetodoObtencion(rs.getString("mtd_obtencion"));
				di.setUnidadMedida(rs.getString("unidad_medida"));
				di.setPeriodoAcumulado(rs.getString("periodo_acumulado"));

				return di;
			}
		});

		// Busco las certificaciones del indicador
		List<Certificacion> certificaciones = getCertificaciones(di.getId());
		List<String> descripcionCertificaciones = new ArrayList<String>();
		for(Certificacion c : certificaciones) {
			descripcionCertificaciones.add(c.getDescripcion());
		}
		di.setCertificaciones(descripcionCertificaciones);
		
		return di;
	}
	
	private List<Certificacion> getCertificaciones(int idComponente) {

		String queryBasicosYEntidad = "SELECT"
				+ " comp.id_componente, CERTDEP.id_certificacion, cert.de_certificacion_det as descripcion"
				+ " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA COMP, RE_MET_FI_CERTIFICACION_DEP CERTDEP, LK_MET_FI_CERTIFICACION CERT"
				+ " WHERE"
				+ " COMP.id_componente = ? AND COMP.id_sistema = ? AND COMP.id_software = ?"
				+ " AND COMP.id_software = CERTDEP.id_software AND COMP.id_sistema = CERTDEP.id_sistema"
				+ " AND COMP.id_componente = CERT.id_componente_hijo AND CERTDEP.id_software = CERT.id_software"
				+ " AND CERTDEP.id_sistema = CERT.id_sistema AND CERTDEP.id_certificacion = CERT.id_certificacion";

		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Certificacion> certList = new ArrayList<Certificacion>();
		List<Map<String,Object>> certRows= jdbcTemplate.queryForList(queryBasicosYEntidad, 
				new Object[]{idComponente, sistema.getIdSistema(), sistema.getIdSoftware()});
		
		for(Map<String, Object> certRow : certRows){

			Certificacion cert = new Certificacion();
			
			if (certRow.get("id_componente") != null)
				cert.setIdComponente(Integer.valueOf((String.valueOf(certRow.get("id_componente")))));
			else cert.setIdComponente(Sistema.DEFAULT_NULL_INT);
			
			if (certRow.get("id_certificacion") != null)
				cert.setIdCertificacion(Integer.valueOf((String.valueOf(certRow.get("id_certificacion")))));
			else cert.setIdCertificacion(Sistema.DEFAULT_NULL_INT);
			
			if (certRow.get("descripcion") != null)
				cert.setDescripcion((String.valueOf(certRow.get("descripcion"))));
			else cert.setDescripcion(Sistema.DEFAULT_NULL_STRING);
		
			certList.add(cert);
		}
		
		return certList;
	}
}
