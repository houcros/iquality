/*
 * 
 */
package com.indra.iquality.dao.jdbctemplateimplem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.indra.iquality.dao.DictionaryOfConceptsDAO;
import com.indra.iquality.model.DescripcionAtributoMaestro;
import com.indra.iquality.model.DescripcionIndicador;
import com.indra.iquality.model.DescriptionOfAttribute;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.singleton.Environment;
import com.indra.iquality.tree.GenericTreeNode;

import oracle.sql.ROWID;

/**
 * Implementation of {@link com.indra.iquality.dao.DictionaryOfConceptsDAO}
 * using JDBC to connect to an Oracle DB.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 14-dic-2015
 * 
 *          The Class DictionaryOfConceptsDAOJDBCTemplateImpl.
 */
public class DictionaryOfConceptsDAOJDBCTemplateImpl extends AbstractDAOJDBCTemplateImpl
		implements DictionaryOfConceptsDAO {

	/** The Constant logger. */
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(DictionaryOfConceptsDAOJDBCTemplateImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.DictionaryOfConceptsDAO#getAllConcepts(java.lang.
	 * String, int)
	 */
	@Override
	public List<GenericTreeNode<DictionaryConcept>> getAllConcepts(String sistema, int software) {

		logger.info("[getAllConcepts] : INIT");

		String query = "WITH CONSULTA " + "AS "
				+ "(select ID_PADRE, id_hijo, id_tipo, ID_SISTEMA, ID_SOFTWARE, ID_ORDEN,DESCRIPCION, id_fila_lk_met_fi_comp, ID_FILA_RE_MET_FI_COMP_TAB "
				+ "from VS_MET_FI_ARBOL_COMP VS " + "), " + "FILTRO as "
				+ "(SELECT DISTINCT ID_HIJO ID_HIJO_FILTRO,ID_SISTEMA,ID_SOFTWARE,ID_ORDEN,ID_TIPO FROM CONSULTA "
				+ "start with ID_TIPO IN ('A','I','L') " + "connect by  NOCYCLE " + "PRIOR ID_PADRE =  ID_HIJO AND "
				+ "prior ID_SOFTWARE =  ID_SOFTWARE AND " + "prior ID_SISTEMA =  ID_SISTEMA ), " + "FILTROHERM as "
				+ "( " + "SELECT ID_HIJO_FILTRO,ID_SISTEMA,ID_SOFTWARE FROM FILTRO " + "UNION "
				+ "SELECT C.ID_HIJO,C.ID_SISTEMA,C.ID_SOFTWARE FROM FILTRO F,VS_MET_FI_ARBOL_COMP C WHERE "
				+ "F.ID_SOFTWARE=C.ID_SOFTWARE AND F.ID_SISTEMA=C.ID_SISTEMA AND F.ID_HIJO_FILTRO=C.ID_PADRE AND F.ID_TIPO='S' AND F.ID_ORDEN='1' AND C.ID_TIPO='S' AND C.ID_ORDEN<>'1' "
				+ "), " + "ARBOL AS " + "( " + "select " + "DESCRIPCION as title, " + "null as tooltip, "
				+ "link, VS.ID_PADRE, VS.ID_HIJO, VS.ID_SOFTWARE, VS.ID_SISTEMA, VS.ID_TIPO, VS.ID_ORDEN, vs.id_fila_lk_met_fi_comp, VS.ID_FILA_RE_MET_FI_COMP_TAB "
				+ "from VS_MET_FI_ARBOL_COMP VS " + "left join " + "FILTROHERM "
				+ "on (VS.ID_HIJO=FILTROHERM.ID_HIJO_FILTRO AND " + "VS.ID_SOFTWARE=FILTROHERM.ID_SOFTWARE AND "
				+ "VS.ID_SISTEMA=FILTROHERM.ID_SISTEMA) "
				+ "where ((ID_PADRE NOT LIKE '%ODS%' AND VS.ID_HIJO NOT LIKE '%ODS%') OR ID_PADRE IS NULL) AND ID_SN_MAESTRA = 'N' AND DESCRIPCION NOT LIKE '%Otros valores%' "
				+ "AND DESCRIPCION NOT LIKE '%No informado%' " + ") " + "select case when connect_by_isleaf = 1 then 0 "
				+ "            when level = 1             then 1 " + "            else                           -1 "
				+ "      end as status, "
				+ "       level,  title, VS.ID_TIPO as tipo, vs.id_fila_lk_met_fi_comp as comp_rowid, VS.ID_FILA_RE_MET_FI_COMP_TAB as ct_rowid "
				+ "from arbol VS " + "start with ID_PADRE is null " + "connect by   NOCYCLE "
				+ "VS.ID_PADRE = prior VS.ID_HIJO AND " + "VS.ID_SOFTWARE =  prior VS.ID_SOFTWARE AND "
				+ "VS.ID_SISTEMA =  prior VS.ID_SISTEMA " + "ORDER SIBLINGS BY  ID_ORDEN ASC, ID_TIPO ";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<GenericTreeNode<DictionaryConcept>> dictionaryConceptList = new ArrayList<GenericTreeNode<DictionaryConcept>>();
		List<Map<String, Object>> dictionaryConceptNodeRows;
		try {
			dictionaryConceptNodeRows = jdbcTemplate.queryForList(query, new Object[] {});
		} catch (Exception e) {
			logger.error("[getAllConcepts] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return new ArrayList<GenericTreeNode<DictionaryConcept>>();
		}

		// Mapeo los resultados a una lista
		for (Map<String, Object> dictionaryConceptNodeRow : dictionaryConceptNodeRows) {

			DictionaryConcept dictionaryConcept = new DictionaryConcept();

			dictionaryConcept.setStatus(
					helper.filterNullInt(Integer.valueOf(String.valueOf(dictionaryConceptNodeRow.get("status")))));
			dictionaryConcept.setLevel(
					helper.filterNullInt(Integer.valueOf(String.valueOf(dictionaryConceptNodeRow.get("level")))));
			dictionaryConcept
					.setConcept(helper.filterNullString(String.valueOf(dictionaryConceptNodeRow.get("title"))));
			dictionaryConcept
					.setTipo((helper.conceptTypeStringToEnum(String.valueOf(dictionaryConceptNodeRow.get("tipo")))));
			// Son ROWIDs the Oracle. Hay que filtrarlos de otra manera
			if (dictionaryConceptNodeRow.get("comp_rowid") != null) {
				dictionaryConcept.setCompRowID((((ROWID) (dictionaryConceptNodeRow.get("comp_rowid"))).stringValue()));
			} else
				dictionaryConcept.setCompRowID(Environment.DEFAULT_NULL_STRING);

			if (dictionaryConceptNodeRow.get("ct_rowid") != null) {
				dictionaryConcept.setCtRowID((((ROWID) (dictionaryConceptNodeRow.get("ct_rowid"))).stringValue()));
			} else
				dictionaryConcept.setCtRowID(Environment.DEFAULT_NULL_STRING);

			GenericTreeNode<DictionaryConcept> dictionaryConceptNode = new GenericTreeNode<DictionaryConcept>(
					dictionaryConcept);
			dictionaryConceptList.add(dictionaryConceptNode);
		}

		logger.debug("[getAllConcepts] : found {} concepts", dictionaryConceptList.size());
		logger.info("[getAllConcepts] : RETURN");
		return dictionaryConceptList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.DictionaryOfConceptsDAO#getDescriptionOfAttribute(
	 * java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public DescriptionOfAttribute getDescriptionOfAttribute(String compRowID, String ctRowID, String sistema,
			int software) {

		logger.info("[getDescriptionOfAttribute] : INIT");

		String queryBasicosYEntidad = "SELECT"
				+ " VSMT.id_componente, VSMT.de_nombre as nombre, RESP.de_area as responsable,"
				+ " VSMT.de_definicion as definicion, VSMT.de_comentario as comentario, VSMT.de_historico as historico,"
				+ " VSMT.de_formula_usuario as mtd_obtencion, VSMT.de_formato as formato,"
				+ " PERACT.de_periodo_act as periodo_act, TIPACT.de_tipo_actualizacion as tipo_act" + " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA VSMT, lk_met_fi_area RESP,"
				+ " lk_met_fi_periodo_act PERACT, lk_met_fi_tipo_actualizacion TIPACT" + " WHERE"
				+ " VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ?" + " AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = RESP.id_software and VSMT.id_sistema = RESP.id_sistema"
				+ " AND VSMT.id_area = RESP.id_area AND VSMT.id_software = PERACT.id_software"
				+ " AND VSMT.id_sistema = PERACT.id_sistema and VSMT.id_periodo_act = PERACT.id_periodo_act"
				+ " AND VSMT.id_software = TIPACT.id_software and VSMT.id_sistema = TIPACT.id_sistema"
				+ " AND VSMT.id_tipo_actualizacion = TIPACT.id_tipo_actualizacion";

		// Hago la query y mapeo a un objeto directamente
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescriptionOfAttribute da;
		try {
			da = jdbcTemplate.queryForObject(queryBasicosYEntidad,
					new Object[] { compRowID, ctRowID, sistema, software }, new RowMapper<DescriptionOfAttribute>() {

						@Override
						public DescriptionOfAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {

							DescriptionOfAttribute da = new DescriptionOfAttribute();

							da.setId(rs.getInt("id_componente"));
							da.setNombre(rs.getString("nombre"));
							da.setResponsable(rs.getString("responsable"));
							da.setDefinicion(rs.getString("definicion"));
							da.setComentarios(rs.getString("comentario"));
							da.setHistorico(rs.getString("historico"));
							da.setMetodoObtencion(rs.getString("mtd_obtencion"));
							da.setFormato(rs.getString("formato"));
							da.setPeriodoActualizacion(rs.getString("periodo_act"));
							da.setTipoActualizacion(rs.getString("tipo_act"));

							return da;
						}
					});
		} catch (Exception e) {
			logger.error("[getDescriptionOfAttribute] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage());
			e.printStackTrace();
			return new DescriptionOfAttribute();
		}

		logger.debug("[getDescriptionOfAttribute] : found description {}", da.toString());
		logger.info("[getDescriptionOfAttribute] : RETURN");
		return da;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indra.iquality.dao.DictionaryOfConceptsDAO#
	 * getDescriptionOfMasterAttribute(java.lang.String, java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public DescripcionAtributoMaestro getDescriptionOfMasterAttribute(String compRowID, String ctRowID, String sistema,
			int software) {

		logger.info("[getDescriptionOfMasterAttribute] : INIT");

		// Preparo un maestro para retornar
		// Lo creo con los campos que tiene de un atributo normal con
		// getDescriptionOfAttribute
		DescripcionAtributoMaestro dam = new DescripcionAtributoMaestro(
				getDescriptionOfAttribute(compRowID, ctRowID, sistema, software));

		// Obtengo los campos propios del maestro, que un atributo normal no
		// tiene
		String queryAtributosDelMaestro = "SELECT"
				+ " VSMT.de_historico_lk as historico_maestro, PERACT.de_periodo_act as periodo_act_maestro,"
				+ " TIPACT.de_tipo_actualizacion as tipo_act_maestro, VSMT.de_formula_usuario_lk as mtd_obtencion_maestro"
				+ " FROM" + " VS_MET_FI_COMPONENTE_TABLA VSMT, LK_MET_FI_PERIODO_ACT PERACT,"
				+ " LK_MET_FI_TIPO_ACTUALIZACION TIPACT" + " WHERE"
				+ " VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ? AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = PERACT.id_software AND VSMT.id_sistema = PERACT.id_sistema"
				+ " AND VSMT.id_periodo_act_lk = PERACT.id_periodo_act AND VSMT.id_software = TIPACT.id_software"
				+ " AND VSMT.id_sistema = TIPACT.id_sistema AND VSMT.id_tipo_actualizacion_lk = TIPACT.id_tipo_actualizacion";

		// Hago la query y mapeo a un objeto directamente
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionAtributoMaestro auxdam;
		try {
			auxdam = jdbcTemplate.queryForObject(queryAtributosDelMaestro,
					new Object[] { compRowID, ctRowID, sistema, software },
					new RowMapper<DescripcionAtributoMaestro>() {

						@Override
						public DescripcionAtributoMaestro mapRow(ResultSet rs, int rowNum) throws SQLException {

							DescripcionAtributoMaestro dam = new DescripcionAtributoMaestro();

							dam.setHistoricoMaestro(rs.getString("historico_maestro"));
							dam.setPeriodoActualizacionMaestro(rs.getString("periodo_act_maestro"));
							dam.setTipoActualizacionMaestro(rs.getString("tipo_act_maestro"));
							dam.setMetodoObtencionMaestro(rs.getString("mtd_obtencion_maestro"));

							return dam;
						}
					});
		} catch (Exception e) {
			logger.error("[getDescriptionOfMasterAttribute] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage());
			e.printStackTrace();
			return new DescripcionAtributoMaestro();
		}

		// Agrego los campos obtenidos al atributo maestro que me había
		// preparado
		dam.setHistoricoMaestro(auxdam.getHistoricoMaestro());
		dam.setPeriodoActualizacionMaestro(auxdam.getPeriodoActualizacionMaestro());
		dam.setTipoActualizacionMaestro(auxdam.getTipoActualizacionMaestro());
		dam.setMetodoObtencionMaestro(auxdam.getMetodoObtencionMaestro());

		logger.debug("[getDescriptionOfMasterAttribute] : found description {}", dam.toString());
		logger.info("[getDescriptionOfMasterAttribute] : RETURN");
		return dam;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indra.iquality.dao.DictionaryOfConceptsDAO#getDescriptionOfIndicator(
	 * java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public DescripcionIndicador getDescriptionOfIndicator(String compRowID, String ctRowID, String sistema,
			int software) {

		logger.info("[getDescriptionOfIndicator] : INIT");

		String queryBasicosYEntidad = "SELECT" + " VSMT.id_componente,"
				+ " VSMT.de_nombre as nombre, RESP.de_area as responsable, VSMT.de_definicion as definicion,"
				+ " VSMT.de_comentario as comentario, VSMT.de_historico as historico,"
				+ " VSMT.de_formula_usuario as mtd_obtencion, VSMT.de_unidad_medida as unidad_medida,"
				+ " PERACU.de_periodo_acum as periodo_acumulado" + " FROM"
				+ " VS_MET_FI_COMPONENTE_TABLA VSMT, LK_MET_FI_AREA RESP, LK_MET_FI_PERIODO_ACUM PERACU"
				+ " WHERE VSMT.COMP_ROWID = ? AND VSMT.CT_ROWID = ? AND VSMT.id_sistema = ? AND VSMT.id_software = ?"
				+ " AND VSMT.id_software = RESP.id_software and VSMT.id_sistema = RESP.id_sistema"
				+ " AND VSMT.id_area = RESP.id_area AND VSMT.id_software = PERACU.id_software"
				+ " AND VSMT.id_sistema = PERACU.id_sistema and VSMT.id_periodo_acum = PERACU.id_periodo_acum";

		// Hago la query y mapeo a un objeto directamente
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DescripcionIndicador di;
		try {
			di = jdbcTemplate.queryForObject(queryBasicosYEntidad,
					new Object[] { compRowID, ctRowID, sistema, software }, new RowMapper<DescripcionIndicador>() {

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
		} catch (Exception e) {
			logger.error("[getDescriptionOfIndicator] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(),
					e.getMessage());
			e.printStackTrace();
			return new DescripcionIndicador();
		}

		// Busco las certificaciones del indicador y se las agrego
		List<Certification> certificaciones = getCertifications(di.getId(), sistema, software);
		List<String> descripcionCertificaciones = new ArrayList<String>();
		for (Certification c : certificaciones) {
			descripcionCertificaciones.add(c.getDescripcion());
		}
		di.setCertificaciones(descripcionCertificaciones);

		logger.debug("[getDescriptionOfIndicator] : found description {}", di.toString());
		logger.info("[getDescriptionOfIndicator] : RETURN");
		return di;
	}

	/**
	 * Gets the certifications of a component for a given system and software
	 * version.
	 *
	 * @param idComponente
	 *            the identifier of the component
	 * @param sistema
	 *            the system
	 * @param software
	 *            the software version
	 * @return the certifications of the component
	 */
	private List<Certification> getCertifications(int idComponente, String sistema, int software) {

		logger.info("[getCertifications] : INIT");

		String queryBasicosYEntidad = "SELECT" + " COMP.ID_COMPONENTE," + " COMP.DE_NOMBRE," + " CERT.DE_CERTIFICACION"
				+ " FROM LK_MET_FI_CERTIFICACION CERT" + " LEFT JOIN LK_MET_FI_COMPONENTE COMP"
				+ " ON(COMP.ID_COMPONENTE = CERT.ID_COMPONENTE_HIJO AND" + " COMP.ID_SOFTWARE = CERT.ID_SOFTWARE AND"
				+ " COMP.ID_SISTEMA = CERT.ID_SISTEMA)" + " WHERE" + " COMP.ID_COMPONENTE = ? AND"
				+ " COMP.ID_SISTEMA = ? AND" + " COMP.ID_SOFTWARE = ?";

		// Hago la query
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Certification> certList = new ArrayList<Certification>();
		List<Map<String, Object>> certRows;
		try {
			certRows = jdbcTemplate.queryForList(queryBasicosYEntidad,
					new Object[] { idComponente, sistema, software });
		} catch (Exception e) {
			logger.error("[getCertifications] : Excepción <{}> | Ayuda: {}  \n {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			return new ArrayList<Certification>();
		}

		// Mapeo a una lista
		for (Map<String, Object> certRow : certRows) {

			Certification cert = new Certification();

			cert.setIdComponente(helper.filterNullInt(Integer.valueOf((String.valueOf(certRow.get("id_componente"))))));
			cert.setNombre(helper.filterNullString(String.valueOf(certRow.get("de_nombre"))));
			cert.setDescripcion(helper.filterNullString(String.valueOf(certRow.get("de_certificacion"))));

			certList.add(cert);
		}

		logger.debug("[getCertifications] : found {} certificates", certList.size());
		logger.info("[getCertifications] : RETURN");
		return certList;
	}

	/**
	 * The auxiliary Class for representing certifications.
	 *
	 * @author Ignacio N. Lucero Ascencio
	 * @version 0.5, 14-dic-2015
	 * 
	 *          The Class Certification.
	 */
	private class Certification {

		/** The identifier of the component. */
		private int idComponente;

		/** The name of the component. */
		private String nombre;

		/** The description of the component. */
		private String descripcion;

		/**
		 * Gets the identifier of the component.
		 *
		 * @return the identifier of the component
		 */
		public int getIdComponente() {
			return idComponente;
		}

		/**
		 * Sets the identifier of the component.
		 *
		 * @param idComponente
		 *            the new identifier of the component
		 */
		public void setIdComponente(int idComponente) {
			this.idComponente = idComponente;
		}

		/**
		 * Gets name of the component.
		 *
		 * @return name of the component
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * Sets name of the component
		 *
		 * @param nombre
		 *            the new name of the component
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Gets description of the component.
		 *
		 * @return description of the component
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * Sets description of the component.
		 *
		 * @param descripcion
		 *            the new description of the component
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}

}
