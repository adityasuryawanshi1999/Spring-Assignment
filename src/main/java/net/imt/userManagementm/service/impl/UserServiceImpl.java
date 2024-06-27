package net.imt.userManagementm.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.AllArgsConstructor;
import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.entity.User;
import net.imt.userManagementm.entity.UserDetail;
import net.imt.userManagementm.exception.ResourceExistsException;
import net.imt.userManagementm.exception.ResourceNotFoundException;
import net.imt.userManagementm.exception.ValidationException;
import net.imt.userManagementm.mapper.UserMapper;
import net.imt.userManagementm.repository.UserDetailRepository;
import net.imt.userManagementm.repository.UserRepository;
import net.imt.userManagementm.service.UserService;
import net.imt.userManagementm.utils.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDetailRepository userDetailRepository;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Override
    @Transactional
    public RequestHandlerDto createUser(RequestHandlerDto requestHandlerDto) throws ValidationException, ResourceExistsException {
        Set<ConstraintViolation<RequestHandlerDto>> violations = validator.validate(requestHandlerDto);
        UserDetail savedUserDetail;
        User savedUser;

        if (violations.isEmpty()) {
            User user = UserMapper.mapToUser(requestHandlerDto);
            UserDetail userDetail = UserMapper.mapToUserDetail(requestHandlerDto);
            if(userRepository.findById(user.getUsername()).orElse(null)!=null){
                throw new ResourceExistsException("Username already exists");
            }
            savedUser = userRepository.save(user);
            savedUserDetail = userDetailRepository.save(userDetail);
        } else {
            throw new ValidationException(MessageBuilder.buildBadRequestMessage(violations));
        }

        return UserMapper.mapToRequestHandlerDto(savedUser, savedUserDetail);
    }

    @Override
    public ResponseHandlerDto getUserByUsername(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));
        UserDetail userDetail = userDetailRepository.findById(username)
                .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));;
        return UserMapper.mapToResponseHandlerDto(user, userDetail);
    }

    @Override
    public List<String> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(User::getUsername).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public RequestHandlerDto updateUser(String username, RequestHandlerDto requestHandlerDto) throws ValidationException {

        Set<ConstraintViolation<RequestHandlerDto>> violations = validator.validate(requestHandlerDto);
        UserDetail savedUserDetail;
        User savedUser;

        if (violations.isEmpty()) {
            if(!requestHandlerDto.getUsername().equalsIgnoreCase(username)){
                throw new ValidationException("You cannot change your username.");
            }

            User user = UserMapper.mapToUser(requestHandlerDto);
            UserDetail userDetail = UserMapper.mapToUserDetail(requestHandlerDto);

            userRepository.findById(username)
                    .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));
            savedUser = userRepository.save(user);
            userDetailRepository.findById(username)
                    .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));
            savedUserDetail = userDetailRepository.save(userDetail);
        } else {
            throw new ValidationException(MessageBuilder.buildBadRequestMessage(violations));
        }

        return UserMapper.mapToRequestHandlerDto(savedUser,savedUserDetail);
    }

    @Transactional
    @Override
    public List<String> deleteUser(List<String> usernames) {
        List<String> failedUsers = new ArrayList<>();
        for(String i: usernames){
            try{
                userRepository.findById(i)
                        .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));
                userRepository.deleteById(i);
                userDetailRepository.findById(i)
                        .orElseThrow(()-> new ResourceNotFoundException("User with given username not found."));
                userDetailRepository.deleteById(i);
            }
            catch (ResourceNotFoundException e){
                failedUsers.add(i);
            }
        }

        return failedUsers;
    }
}
