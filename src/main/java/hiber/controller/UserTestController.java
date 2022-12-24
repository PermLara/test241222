package hiber.controller;

import hiber.model.UserTest;
import hiber.service.UserTestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserTestController {

    @Autowired
    private UserTestServiceImp userTestServiceImp;

    @GetMapping(value = "/usertest")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        UserTest userTest = new UserTest();
        userTest.setName("entry_" + UserTest.count);
        userTestServiceImp.addUserTest(userTest);  //в базу
        messages.add("UserTest here: ");
        messages.add(String.valueOf(userTest.getId()));
        messages.add(userTest.getName());
        model.addAttribute("messages", messages);
        System.out.println("Контроллер /usertest отработал");
        return "index";
    }

}