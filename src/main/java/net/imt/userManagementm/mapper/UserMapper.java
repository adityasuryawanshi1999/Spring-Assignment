package net.imt.userManagementm.mapper;

import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.entity.User;
import net.imt.userManagementm.entity.UserDetail;

public class UserMapper {

    public static User mapToUser(RequestHandlerDto requestHandlerDto){
        return new User(
                requestHandlerDto.getUsername(),
                requestHandlerDto.getPassword()
        );
    }

    public static UserDetail mapToUserDetail(RequestHandlerDto requestHandlerDto){
        return new UserDetail(
                requestHandlerDto.getUsername(),
                requestHandlerDto.getPhoneNo(),
                requestHandlerDto.getAddress()
        );
    }

    public static RequestHandlerDto mapToRequestHandlerDto(User user, UserDetail userDetail){
        return new RequestHandlerDto(
                user.getUsername(),
                user.getPassword(),
                userDetail.getPhoneNo(),
                userDetail.getAddress()
        );
    }

    public static ResponseHandlerDto mapToResponseHandlerDto(User user, UserDetail userDetail){
        return new ResponseHandlerDto(
                user.getUsername(),
                userDetail.getPhoneNo(),
                userDetail.getAddress()
        );
    }

}
