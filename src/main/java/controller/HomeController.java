package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.QueueServiceImpl;

@Controller
public class HomeController {

    static final Logger logger = LogManager.getLogger(HomeController.class.getName());

    @Autowired
    private QueueServiceImpl queueService;

    @RequestMapping("home")
    public String requestHome(Model model) {
        model.addAttribute("queueList", queueService.selectQueues());
        return "home";
    }
}
