package net.imt.userManagementm.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerDtoTest {

    ResponseHandlerDto responseHandlerDto = new ResponseHandlerDto();

    @Test
    void getUsername() {
        Assertions.assertEquals(RESPONSE_HANDLER_DTO.getUsername(),USER_NAME);
    }



    @Test
    void getPhoneNo() {
        Assertions.assertEquals(RESPONSE_HANDLER_DTO.getPhoneNo(),PHONE_NUMBER);
    }

    @Test
    void getAddress() {
        Assertions.assertEquals(RESPONSE_HANDLER_DTO.getAddress(),ADDRESS);
    }

    @Test
    void setUsername() {
        responseHandlerDto.setUsername("newUserName");
        Assertions.assertEquals(responseHandlerDto.getUsername(),"newUserName");
    }

    @Test
    void setPhoneNo() {
        responseHandlerDto.setPhoneNo("newPhoneNumber");
        Assertions.assertEquals(responseHandlerDto.getPhoneNo(),"newPhoneNumber");
    }

    @Test
    void setAddress() {
        responseHandlerDto.setAddress("newAddress");
        Assertions.assertEquals(responseHandlerDto.getAddress(),"newAddress");
    }
}