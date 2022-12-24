package hiber.controller;

import hiber.model.CarTest;
import hiber.service.CarTestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarTestController {

    @Autowired
    private CarTestServiceImp carTestService;

    @GetMapping(value = "/cartest")
    public String listCar(ModelMap model) {
        System.out.println("запустился CarTestController");
        List<CarTest> listCarTest = carTestService.listCarTest();
        model.addAttribute("listCarTest", listCarTest);
        System.out.println("сработал CarTestController");
        return "cartest";
    }
}
