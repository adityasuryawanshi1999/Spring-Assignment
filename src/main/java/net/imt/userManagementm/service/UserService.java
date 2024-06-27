package net.imt.userManagementm.service;

import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.dto.UserDto;
import net.imt.userManagementm.exception.ResourceExistsException;
import net.imt.userManagementm.exception.ValidationException;

import java.util.List;

public interface UserService {
//    UserDto createUser(UserDto userDto);
    RequestHandlerDto createUser(RequestHandlerDto requestHandlerDto) throws ValidationException, ResourceExistsException;
    ResponseHandlerDto getUserByUsername(String username);
    List<String> getAllUsers();
    RequestHandlerDto updateUser(String username, RequestHandlerDto requestHandlerDto) throws ValidationException;
    List<String> deleteUser(List<String> usernames);
}
