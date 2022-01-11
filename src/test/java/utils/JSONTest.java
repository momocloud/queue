package utils;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Task;
import pojo.TaskToShow;
import service.TaskService;

import java.util.List;

public class JSONTest {
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-application-config.xml");
        TaskService taskService = context.getBean("taskService", TaskService.class);
        List<TaskToShow> taskList = taskService.selectTaskToShowByQId(2);
        String taskListJsonStr = JSONArray.toJSONString(taskList);
        System.out.println(taskListJsonStr);
    }

}
