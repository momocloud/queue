package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-application-config.xml");
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println("=====TEST1.1=====");
        userService.selectUsers().forEach(System.out::println);

        System.out.println("=====TEST1.2=====");
        System.out.println(userService.selectUserById(1));

        System.out.println("=====TEST1.3=====");
        userService.selectUserByNameFuzzy("u").forEach(System.out::println);
    }

}
