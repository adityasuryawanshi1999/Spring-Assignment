package net.imt.userManagementm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDetailTest {

    UserDetail userDetail = new UserDetail();
    @Test
    void getUsername() {
        Assertions.assertEquals(USER_DETAIL.getUsername(),USER_NAME);
    }

    @Test
    void getPhoneNo() {
        Assertions.assertEquals(USER_DETAIL.getPhoneNo(),PHONE_NUMBER);
    }

    @Test
    void getAddress() {
        Assertions.assertEquals(USER_DETAIL.getAddress(),ADDRESS);
    }


    @Test
    void setUsername() {
        userDetail.setUsername("NewUser");
        Assertions.assertEquals(userDetail.getUsername(),"NewUser");
    }


    @Test
    void setPhoneNo() {
        userDetail.setPhoneNo("NewPhone");
        Assertions.assertEquals(userDetail.getPhoneNo(),"NewPhone");

    }

    @Test
    void setAddress() {
        userDetail.setAddress("NewAddress");
        Assertions.assertEquals(userDetail.getAddress(),"NewAddress");

    }
}