package sk.tsystems.lzm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import sk.tsystems.lzm.service.VaccineService;

@Controller
public class VaccineController {

    @Autowired
    VaccineService vaccineService;


    @RequestMapping("/vaccine")
    public String mainPage(Model model){
        prepareModel(model);
        return ("vaccine");
    }


    private void prepareModel(Model model){
        model.addAttribute("allVaccine", vaccineService.getAllVaccine());

    }

}
