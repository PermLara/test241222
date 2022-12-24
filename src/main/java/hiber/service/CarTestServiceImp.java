package hiber.service;

import org.springframework.stereotype.Service;
import hiber.model.CarTest;

import java.util.List;

@Service
public class CarTestServiceImp implements CarTestService {

    private final List<CarTest> makeCarTest = List.of(new CarTest(), new CarTest(), new CarTest(), new CarTest(), new CarTest());

    @Override
    public List<CarTest> listCarTest() {
        System.out.println("возвращаю makeCars "+ (long) makeCarTest.size());
        return makeCarTest;
    }
}
