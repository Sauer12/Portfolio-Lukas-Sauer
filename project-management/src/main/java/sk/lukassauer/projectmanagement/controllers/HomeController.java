package sk.lukassauer.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.lukassauer.projectmanagement.dao.IEmployeeRepository;
import sk.lukassauer.projectmanagement.dao.IProjectRepository;
import sk.lukassauer.projectmanagement.dto.ChartData;
import sk.lukassauer.projectmanagement.dto.EmployeeProject;
import sk.lukassauer.projectmanagement.entities.Employee;
import sk.lukassauer.projectmanagement.entities.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        // querying the db for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.projectsStage();

        // convert projectData object into a json structure for use in JS
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // ["NOTSRATED", 1], ["INRPOGRESS", 2], ["COMPLETED"," 1]
        model.addAttribute("projectsStatusCount", jsonString);
        System.out.println(jsonString);

        // querying the db for employees
        List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
        model.addAttribute("employeesList", employeesProjectCount);

        return "main/home";
    }
}
