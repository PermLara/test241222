package hiber.dao;

import hiber.model.User;
import hiber.model.UserTest;

public interface UserTestDao {
    UserTest getUserTest(Long id);

    void addUserTest(UserTest userTest);
}
