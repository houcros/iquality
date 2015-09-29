package com.indra.iquality.controller;

import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iquality.dao.EmployeeDAO;
import com.indra.iquality.model.Employee;
import com.indra.iquality.dao.LK_MET_PLA_CTRL_PASEDAO;
import com.indra.iquality.model.LK_MET_PLA_CTRL_PASE;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_LK_MET_PLA_CTRL_PASE = "show_lk_met_pla_ctrl_pase";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}
	
	// Ahora uso este modelo, pero despues tendría que usar los específicos
	// de la capa de datos???
	
	// Por qué return string? Puedo retornar algo mejor o no?
	@RequestMapping(value = "/iquality", method = RequestMethod.GET)
	public String iquality(ModelMap model) {

		// Hago cosas con la BBDD
		
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
		
		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("Pankaj");
		emp.setRole("Java Developer");
		
		//Create
		employeeDAO.save(emp);
		
		//Read
		Employee emp1 = employeeDAO.getById(rand);
		System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		emp.setRole("CEO");
		employeeDAO.update(emp);
		
		//Get All
		List<Employee> empList = employeeDAO.getAll();
		System.out.println(empList);
		
		//Delete
		employeeDAO.deleteById(rand);
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
		//Fin de cosas con la BBDD
		
		model.addAttribute("insert", emp1);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/lk_met_pla_ctrl_pase/{id_ejecucion}", method = RequestMethod.GET)
	public String show_lk_met_pla_ctrl_pase(@PathVariable int id_ejecucion, ModelMap model) {

		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		//To use JdbcTemplate
		LK_MET_PLA_CTRL_PASEDAO lk_met_pla_ctrl_paseDAO = ctx.getBean("lk_met_pla_ctrl_paseDAOJDBCTemplate", LK_MET_PLA_CTRL_PASEDAO.class);
		
		//Read
		logger.debug("[show_lk_met_pla_ctrl_pase] counter : {}, ready to getById", ++counter);
		LK_MET_PLA_CTRL_PASE lk_met_pla_ctrl_pase;
		try {
			lk_met_pla_ctrl_pase = lk_met_pla_ctrl_paseDAO.getById(id_ejecucion);
			
			logger.debug("[show_lk_met_pla_ctrl_pase] counter : LK_MET_PLA_CTRL_PASE Retrieved::{}", lk_met_pla_ctrl_pase);
			
			model.addAttribute("id_sistema", lk_met_pla_ctrl_pase.getId_sistema());
			model.addAttribute("id_ejecucion", lk_met_pla_ctrl_pase.getId_ejecucion());
			model.addAttribute("id_software", lk_met_pla_ctrl_pase.getId_software());
			model.addAttribute("id_pase", lk_met_pla_ctrl_pase.getId_pase());
			model.addAttribute("de_pase", lk_met_pla_ctrl_pase.getDe_pase());
			model.addAttribute("id_fecha_inicio", lk_met_pla_ctrl_pase.getId_fecha_inicio());
			model.addAttribute("id_fecha_inicio_real", lk_met_pla_ctrl_pase.getId_fecha_inicio_real());
			model.addAttribute("id_fecha_fin_real", lk_met_pla_ctrl_pase.getId_fecha_fin_real());
			model.addAttribute("id_estado", lk_met_pla_ctrl_pase.getId_estado());
			model.addAttribute("id_sn_habilitado", lk_met_pla_ctrl_pase.getId_sn_habilitado());
			model.addAttribute("id_anyo", lk_met_pla_ctrl_pase.getId_anyo());
			model.addAttribute("id_mes", lk_met_pla_ctrl_pase.getId_mes());
			model.addAttribute("id_escenario", lk_met_pla_ctrl_pase.getId_escenario());
			model.addAttribute("id_fecha_creacion", lk_met_pla_ctrl_pase.getId_fecha_creacion());
			model.addAttribute("id_fecha_modificacion", lk_met_pla_ctrl_pase.getId_fecha_modificacion());
			model.addAttribute("id_pid", lk_met_pla_ctrl_pase.getId_pid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close Spring Context
		ctx.close();
		System.out.println("DONE");
		
		logger.debug("[welcomeName] counter : {}", ++counter);
		return VIEW_LK_MET_PLA_CTRL_PASE;

	}

}