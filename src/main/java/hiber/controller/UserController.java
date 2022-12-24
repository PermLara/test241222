package hiber.controller;

import hiber.model.CarTest;
import hiber.model.User;
import hiber.service.CarTestServiceImp;
import hiber.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping(value = "/users")
    public String listUsers(ModelMap model) {
        List<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        System.out.println("UserController наловил водителей с тачками");
        for (User u: listUsers) {
            System.out.println(u);
        }

        return "users";
    }
}
