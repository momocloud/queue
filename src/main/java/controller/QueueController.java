package controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.Queue;
import pojo.Task;
import pojo.TaskToShow;
import pojo.User;
import service.QueueServiceImpl;
import service.TaskServiceImpl;
import utils.Constant;
import utils.IDUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class QueueController {

    @Autowired
    private QueueServiceImpl queueService;

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping("queue/{qId}")
    public String getOneQueue(Model model, @PathVariable("qId") int qId, HttpSession session) {
        System.out.println(qId);
        Queue queue = queueService.selectQueueById(qId);
        if (queue != null) {
            model.addAttribute("queue", queue);

            User user = (User) session.getAttribute("user");
            int uId = user.getId();
            List<Task> taskList = taskService.selectTaskByDoubleId(uId, qId);
            if (taskList.size() == 0) {
                model.addAttribute("buttonText", Constant.buttonText0);
            } else {
                model.addAttribute("buttonText", Constant.buttonText1);
            }
            model.addAttribute("userIdentity", user.getIdentity());
            return "queue";
        } else {
            return "home";
        }
    }

    @GetMapping(value = "/queueStatus/{qID}")
    @ResponseBody
    public String getQueueStatus(@PathVariable("qID") Integer qID) {
        List<TaskToShow> taskList = taskService.selectTaskToShowByQId(qID);
        String taskListJsonStr = JSONArray.toJSONString(taskList);
        return taskListJsonStr;
    }

    @PostMapping(value = "/submit/{qID}")
    @ResponseBody
    public void postQueueSubmit(@PathVariable("qID") Integer qID, HttpSession session, String comment, String location) {
        User user = (User) session.getAttribute("user");
        if (qID != null && user != null) {
            int uID = user.getId();
            List<Task> taskList = taskService.selectTaskByDoubleId(uID, qID);
            if (taskList.size() == 0) {
                Date date = new Date();
                Task task = new Task(IDUtils.generateID(), uID, qID, comment, location, date);
                System.out.println(task);
                taskService.insertTask(task);
            } else {
                Task task = taskList.get(0);
                taskService.deleteTaskById(task.getId());
            }
        }
    }

    @DeleteMapping("/delete/{taskID}")
    @ResponseBody
    public void postTaskDelete(HttpSession session, @PathVariable("taskID") String taskId) {
        User user = (User) session.getAttribute("user");
        Task task = taskService.selectTaskById(taskId);
        if (user != null && task != null) {
            int identify = user.getIdentity();
            int qId = task.getQId();
            if (identify == qId) {
                taskService.deleteTaskById(taskId);
            }
        }
    }
}
