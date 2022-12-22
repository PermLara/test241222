package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        User newUser;
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        for (int i = 15; i <= 15; i++) {
            newUser = new User("User" + i, "Lastname" + i, "user" + i + "@mail.ru");
            newUser.setPrivateCar(new Car("Model" + i, i * 1000 + i * 10 + i));
            userService.add(newUser);
        }

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }

        System.out.println(userService.findByCarAttributes("Model13", 13143));
        context.close();
    }
}
