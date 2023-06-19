package sk.lukassauer.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.lukassauer.projectmanagement.dao.IEmployeeRepository;
import sk.lukassauer.projectmanagement.entities.Employee;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployyController {

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createProject(Employee employee, Model model){
        // this should handle saving to the DB...
        empRepo.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/add";
    }
}
