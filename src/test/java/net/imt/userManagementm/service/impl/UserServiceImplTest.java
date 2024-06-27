package net.imt.userManagementm.service.impl;

import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.entity.User;
import net.imt.userManagementm.repository.UserDetailRepository;
import net.imt.userManagementm.repository.UserRepository;
import net.imt.userManagementm.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository userRepository;
    @Mock
    UserDetailRepository userDetailRepository;

    @Test
    void getUserByUsername() {
        Mockito.when(userRepository.findById(TestData.USER_NAME)).thenReturn(Optional.ofNullable(TestData.USER));
        Mockito.when(userDetailRepository.findById(TestData.USER_NAME)).thenReturn(Optional.ofNullable(TestData.USER_DETAIL));
        ResponseHandlerDto responseHandlerDto = userServiceImpl.getUserByUsername(TestData.USER_NAME);
        Assertions.assertEquals(responseHandlerDto.getUsername(),TestData.USER_NAME);
        Assertions.assertEquals(responseHandlerDto.getAddress(),TestData.ADDRESS);
    }
}