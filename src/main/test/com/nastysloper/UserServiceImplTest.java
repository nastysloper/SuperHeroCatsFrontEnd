package com.nastysloper;

import com.nastysloper.model.User;
import com.nastysloper.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    @Test
    void createNewUser() {
        User u1 = new User(1, "Tester", "test@test.com", "myphoto");
        UserServiceImpl service = new UserServiceImpl();
        service.createNewUser(1, "Tester", "test@test.com", "myphoto");
        User u2 = service.findByName("Tester").get();
        assert u2.equals(u1);
    }
}