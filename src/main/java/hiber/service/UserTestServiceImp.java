package hiber.service;

import hiber.dao.UserTestDao;
import hiber.dao.UserTestDaoImp;
import hiber.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImp implements UserTestService {

    @Autowired
    private UserTestDaoImp userTestDao;

    @Override
    public UserTest getUserTest(Long id) {
        return userTestDao.getUserTest(id);
    }

    @Override
    public void addUserTest(UserTest userTest) {
        userTestDao.addUserTest(userTest);
    }
}
