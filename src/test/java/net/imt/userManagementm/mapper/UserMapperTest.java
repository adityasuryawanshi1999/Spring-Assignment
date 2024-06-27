package net.imt.userManagementm.mapper;

import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.entity.User;
import net.imt.userManagementm.entity.UserDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.imt.userManagementm.testData.TestData.*;


class UserMapperTest {

    @Test
    void testMapToUser() {
        User newUser = UserMapper.mapToUser(REQUEST_HANDLER_DTO);
        Assertions.assertEquals(newUser.getUsername(),USER_NAME);
        Assertions.assertEquals(newUser.getPassword(),PASSWORD);
    }

    @Test
    void testMapToUserDetail() {
        UserDetail newNewUserDetail = UserMapper.mapToUserDetail(REQUEST_HANDLER_DTO);
        Assertions.assertEquals(newNewUserDetail.getUsername(),USER_NAME);
        Assertions.assertEquals(newNewUserDetail.getPhoneNo(),PHONE_NUMBER);
        Assertions.assertEquals(newNewUserDetail.getAddress(),ADDRESS);
    }

    @Test
    void testMapToRequestHandlerDto() {
        RequestHandlerDto newRequestHandlerDto = UserMapper.mapToRequestHandlerDto(USER, USER_DETAIL);
        Assertions.assertEquals(newRequestHandlerDto.getUsername(),USER_NAME);
        Assertions.assertEquals(newRequestHandlerDto.getAddress(),ADDRESS);
        Assertions.assertEquals(newRequestHandlerDto.getPhoneNo(),PHONE_NUMBER);
        Assertions.assertEquals(newRequestHandlerDto.getPassword(),PASSWORD);
    }

    @Test
    void testMapToResponseHandlerDto() {
        ResponseHandlerDto responseHandlerDto = UserMapper.mapToResponseHandlerDto(USER, USER_DETAIL);
        Assertions.assertEquals(responseHandlerDto.getUsername(),USER_NAME);
        Assertions.assertEquals(responseHandlerDto.getAddress(),ADDRESS);
        Assertions.assertEquals(responseHandlerDto.getPhoneNo(),PHONE_NUMBER);
    }
}