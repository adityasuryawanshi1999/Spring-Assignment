package net.imt.userManagementm.entity;

import net.imt.userManagementm.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User();
    @Test
    void getUsername() {
        Assertions.assertEquals(USER.getUsername(),USER_NAME);
    }

    @Test
    void getPassword() {
        Assertions.assertEquals(USER.getPassword(),PASSWORD);
    }

    @Test
    void setUsername() {
        user.setUsername("newUserName");
        Assertions.assertEquals(user.getUsername(),"newUserName");

    }

    @Test
    void setPassword() {
        user.setPassword("newPass");
        Assertions.assertEquals(user.getPassword(),"newPass");

    }
}