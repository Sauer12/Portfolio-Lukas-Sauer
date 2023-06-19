package sk.tuke.gamestudio.server.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {

    private String loggedUser = null;

    @RequestMapping("/login")
    public String login(String login, String password){
        if(("heslo").equals(password)){
            loggedUser = login.trim();
            if(loggedUser.length() > 0){
                return "redirect:/gamestudio";
            }
        }
        loggedUser = null;
        return "redirect:/gamestudio";
    }

    @RequestMapping("/logout")
    public String logout(){
        loggedUser = null;
        return "redirect:/gamestudio";
    }


    public String getLoggedUser() {
        return loggedUser;
    }

    public boolean isLogged(){
        return loggedUser != null;
    }
}
