package com.shiv.bootmvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shiv.bootmvc.dao.EmployeeDAO;
import com.shiv.bootmvc.model.Employee;

import antlr.collections.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDAO edao;
	
	@RequestMapping(path="/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping(value="/employee",consumes = "application/json", produces = "application/json")
	public Employee addEmployee(@RequestBody Employee emp) {
				
		System.out.println(emp.toString());
		 edao.save(emp);
		 return emp;
		
	}
	@RequestMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") int id) {
			
			return edao.findById(id);
			
	}
	
	
	@GetMapping(value="/employees")
	public java.util.List<Employee> getEmployees() {
		return edao.findAll();
		
	}
	
	@PutMapping(path="/employee",consumes = "application/json", produces = "application/json")
	public Employee saveOrUpdateEmployee(@RequestBody Employee ne) {
		
		 edao.save(ne);
		 return ne;
		
	}
	
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam("id") int id) {
		System.out.println(id);
		edao.deleteById(id);
		return "Deleted";
	}
	
	
	//Service for particular Date
	@GetMapping(path="/employee/today")
	public java.util.List<Employee> hireToday()	
	 {
		
		Date date= new Date();
		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
		
	try {
			 Date today=s.parse(s.format(date));
			 return edao.findByHireDate(today);				
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			return null;
	}
		
	}
	
	//Service for particular Date
	@GetMapping(path="/employee/date")
	public java.util.List<Employee> hireOnDate(@RequestParam("hireDate") String hire_date)	
	 {
		
		System.out.println(hire_date);
		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1=s.parse(hire_date);
				return edao.findByHireDate(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Service for Before particular Date
		@GetMapping(path="/employee/beforedate")
		public java.util.List<Employee> hireBeforeGivenDate(@RequestParam("hireDate") String hire_date)	
		 {
			
			System.out.println(hire_date);
			SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date d1=s.parse(hire_date);
					return edao.findByHireDateLessThan(d1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		//Service for after particular Date
				@GetMapping(path="/employee/afterdate")
				public java.util.List<Employee> hireAfterGivenDate(@RequestParam("hireDate") String hire_date)	
				 {
					
					System.out.println(hire_date);
					SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date d1=s.parse(hire_date);
							return edao.findByHireDateGreaterThan(d1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
					
				}
		
				
				//Service for between Dates
    @GetMapping(path="/employee/betweendate")
    public java.util.List<Employee> hireBetweenGivenDate(@RequestParam("hireDate1") String hire_date1,@RequestParam("hireDate2") String hire_date2)	
					 {
						
						System.out.println(hire_date1);
						System.out.println(hire_date2);
						SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
						try {
							Date d1=s.parse(hire_date1);
							Date d2=s.parse(hire_date2);
							return edao.findByHireDateBetween(d1,d2);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						}
						
					}
			

	
//	@GetMapping(value="/employee/details/{id}")
//	public Optional<Employee> getEmployeeName(@PathVariable("id") int ){
//		
//		return edao.findByFirstName(firstName);
//	}
}
