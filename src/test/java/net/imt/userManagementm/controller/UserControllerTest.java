package net.imt.userManagementm.controller;

import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.exception.ValidationException;
import net.imt.userManagementm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static net.imt.userManagementm.testData.TestData.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    @Test
    void createUser() throws ValidationException {
        Mockito.when(userService.createUser(any(RequestHandlerDto.class))).thenReturn(REQUEST_HANDLER_DTO);
        ResponseEntity responseEntity = userController.createUser(REQUEST_HANDLER_DTO);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void getUserByUsername() {
        Mockito.when(userService.getUserByUsername(USER_NAME)).thenReturn(RESPONSE_HANDLER_DTO);
        ResponseEntity responseEntity = userController.getUserByUsername(USER_NAME);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getAllUsers() {
        Mockito.when(userService.getAllUsers()).thenReturn(List.of("A","B","C"));
        ResponseEntity responseEntity = userController.getAllUsers();
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    void updateUser() throws ValidationException {
        Mockito.when(userService.updateUser(USER_NAME,REQUEST_HANDLER_DTO)).thenReturn(REQUEST_HANDLER_DTO);
        ResponseEntity responseEntity = userController.updateUser(USER_NAME,REQUEST_HANDLER_DTO);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteUser() {
        Mockito.when(userService.deleteUser(List.of("A","B","C"))).thenReturn(List.of("A","B","C"));
        ResponseEntity responseEntity = userController.deleteUser(List.of("A","B","C"));
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
}