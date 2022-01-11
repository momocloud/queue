package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String rootPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:home";
        }
        return "redirect:login";
    }

    @GetMapping("login")
    public String getLogin(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:home";
        }
        logger.info("New Log!");
        return "login";
    }

    @PostMapping("login")
    public String postLogin(HttpSession session, @RequestParam("username") String name, @RequestParam("passwd") String password) {
        session.setAttribute("user", userService.verifyLogin(name, password));
        return "redirect:home";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }

}
