package net.imt.userManagementm.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;

class RequestHandlerDtoTest {


    RequestHandlerDto requestHandlerDto = new RequestHandlerDto();

    @Test
    void getUsername() {
        Assertions.assertEquals(REQUEST_HANDLER_DTO.getUsername(),USER_NAME);
    }

    @Test
    void getPassword() {
        Assertions.assertEquals(REQUEST_HANDLER_DTO.getPassword(),PASSWORD);
    }

    @Test
    void getPhoneNo() {
        Assertions.assertEquals(REQUEST_HANDLER_DTO.getPhoneNo(),PHONE_NUMBER);
    }

    @Test
    void getAddress() {
        Assertions.assertEquals(REQUEST_HANDLER_DTO.getAddress(),ADDRESS);
    }

    @Test
    void setUsername() {
        requestHandlerDto.setUsername("newUserName");
        Assertions.assertEquals(requestHandlerDto.getUsername(),"newUserName");
    }

    @Test
    void setPassword() {
        requestHandlerDto.setPassword("newPass");
        Assertions.assertEquals(requestHandlerDto.getPassword(),"newPass");
    }

    @Test
    void setPhoneNo() {
        requestHandlerDto.setPhoneNo("newPhoneNumber");
        Assertions.assertEquals(requestHandlerDto.getPhoneNo(),"newPhoneNumber");
    }

    @Test
    void setAddress() {
        requestHandlerDto.setAddress("newAddress");
        Assertions.assertEquals(requestHandlerDto.getAddress(),"newAddress");
    }
}