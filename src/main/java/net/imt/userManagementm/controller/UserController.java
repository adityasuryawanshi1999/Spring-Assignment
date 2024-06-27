package net.imt.userManagementm.controller;

import lombok.AllArgsConstructor;
import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.exception.ResourceExistsException;
import net.imt.userManagementm.exception.ValidationException;
import net.imt.userManagementm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<RequestHandlerDto> createUser(@RequestBody RequestHandlerDto requestHandlerDto)
            throws ValidationException, ResourceExistsException {
        RequestHandlerDto savedUser = userService.createUser(requestHandlerDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{username}")
    public ResponseEntity<ResponseHandlerDto> getUserByUsername(@PathVariable("username") String username){
        ResponseHandlerDto foundUser = userService.getUserByUsername(username);
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllUsers(){
        List<String> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PatchMapping("{username}")
    public ResponseEntity<RequestHandlerDto> updateUser(@PathVariable("username") String username
            , @RequestBody RequestHandlerDto requestHandlerDto) throws ValidationException{
        RequestHandlerDto savedUser = userService.updateUser(username,requestHandlerDto);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody List<String> usernames){
        List<String> failed = userService.deleteUser(usernames);

        if(failed.isEmpty()) return ResponseEntity.ok("All requested users deleted successfully.");
        else return ResponseEntity.ok("Failed user deletions: " + failed);
    }
}
