package net.imt.userManagementm.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    UserDto userDto = new UserDto();
    UserDto userDto2 = new UserDto(null,"dummyPass");

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
        userDto.setUsername("newUserName");
        Assertions.assertEquals(userDto.getUsername(),"newUserName");

    }

    @Test
    void setPassword() {
        userDto.setPassword("newPass");
        Assertions.assertEquals(userDto.getPassword(),"newPass");

    }

    @Test
    void testConstructor() {
        Assertions.assertEquals(userDto2.getPassword(),"dummyPass");
        Assertions.assertNull(userDto2.getUsername());


    }
}