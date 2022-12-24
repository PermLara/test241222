package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User newUser;
        newUser = new User("User" + 1, "Lastname" + 1, "user" + 1 + "@mail.ru");
        System.out.println(newUser);
    }
}