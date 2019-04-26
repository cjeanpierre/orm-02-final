package com.puthisastra.first;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class MainController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@GetMapping
    @ResponseBody
    public List<Person> getListPerson() {
		return personRepository.findAll();
    }
	
	@GetMapping("/departments")
    @ResponseBody
    public List<Department> getListDepartment() {
		return departmentRepository.findAll();
    }
	
	@GetMapping("/roles")
    @ResponseBody
    public List<Role> getListRoles() {
		return roleRepository.findAll();
    }
	
	@GetMapping("/adress")
    @ResponseBody
    public List<Adress> getListAdress() {
		return adressRepository.findAll();
    }
	
	@GetMapping("/create")
    @ResponseBody
    public Person createPerson() {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAge(13);
		person.setLastUpdatedTime(new Date());
		Department department = new Department();
		department.setName("Test");
		department = departmentRepository.save(department);
		person.setDepartment(department);
		Role role = new Role();
		role.setName("boss");
		role = roleRepository.save(role);
		person.setRole(role);
		Adress adress = new Adress();
		adress.setName("billy");
		adress = adressRepository.save(adress);
		
		Adress adress2 = new Adress();
		adress2 = adressRepository.save(adress2);
		adress2.setName("lilly");
		
		person.setAdress(Arrays.asList(adress, adress2));
		return personRepository.save(person);
    }
	
	
}
