package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Task;
import utils.IDUtils;

import java.util.Date;

public class TaskTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-application-config.xml");
        TaskService taskService = context.getBean("taskService", TaskService.class);

        System.out.println("=====TEST1.1=====");
        taskService.selectTasks().forEach(System.out::println);

        System.out.println("=====TEST1.2=====");
        System.out.println(taskService.selectTaskByQId(1));

        System.out.println("=====TEST1.3=====");
        System.out.println(taskService.selectTaskByUId(1));

        System.out.println("=====TEST1.4=====");
        System.out.println(taskService.selectTaskByDoubleId(1, null));

        System.out.println("=====TEST1.5=====");
        System.out.println(taskService.selectTaskByDoubleId(null, 2));

        System.out.println("=====TEST1.6=====");
        System.out.println(taskService.selectTaskByDoubleId(2, 2));

        System.out.println("=====TEST1.7=====");
        System.out.println(taskService.selectTaskByDoubleId(1, 2));

        System.out.println("=====TEST1.8=====");
        System.out.println(taskService.selectTaskByDoubleId(null, null));

        System.out.println("=====TEST1.9=====");
        System.out.println(taskService.selectTaskById("5b3d1b7601fa41fe8d7ac62c4700c412"));
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-application-config.xml");
        TaskService taskService = context.getBean("taskService", TaskService.class);
        System.out.println(new Task(IDUtils.generateID(), 1, 1, "TEST", "TEST", new Date()).getUId());
        taskService.insertTask(new Task(IDUtils.generateID(), 1, 1, "TEST", "TEST", new Date()));
    }
}
