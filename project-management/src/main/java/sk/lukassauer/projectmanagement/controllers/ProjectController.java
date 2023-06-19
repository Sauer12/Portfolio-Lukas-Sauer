package sk.lukassauer.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.lukassauer.projectmanagement.dao.IEmployeeRepository;
import sk.lukassauer.projectmanagement.dao.IProjectRepository;
import sk.lukassauer.projectmanagement.entities.Employee;
import sk.lukassauer.projectmanagement.entities.Project;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping
    public String displayEmployees(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project project = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", project);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        // this should handle saving to the DB...
        proRepo.save(project);

//        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
//
//        for(Employee emp : chosenEmployees){
//            emp.set(project);
//            empRepo.save(emp);
//        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
