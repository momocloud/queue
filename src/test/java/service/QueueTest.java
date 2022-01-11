package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueueTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-application-config.xml");
        QueueService queueService = context.getBean("queueService", QueueService.class);

        System.out.println("=====TEST1.1=====");
        queueService.selectQueues().forEach(System.out::println);

        System.out.println("=====TEST1.2=====");
        System.out.println(queueService.selectQueueById(3));

        System.out.println("=====TEST1.3=====");
        queueService.selectQueueByName("I").forEach(System.out::println);

        System.out.println("=====TEST1.4=====");
        System.out.println(queueService.selectQueueByName("0"));
    }
}
