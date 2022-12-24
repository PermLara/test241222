package hiber.service;

import hiber.model.UserTest;

public interface UserTestService {
    UserTest getUserTest(Long id);

    void addUserTest(UserTest userTest);
}
