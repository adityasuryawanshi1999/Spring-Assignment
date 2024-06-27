package net.imt.userManagementm.testData;

import jakarta.validation.ConstraintViolation;
import net.imt.userManagementm.dto.RequestHandlerDto;
import net.imt.userManagementm.dto.ResponseHandlerDto;
import net.imt.userManagementm.entity.User;
import net.imt.userManagementm.entity.UserDetail;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;

public class TestData {
    public static String USER_NAME = "userName";
    public static String PASSWORD = "password";
    public static String PHONE_NUMBER = "1234567890";
    public static String ADDRESS = "address";
    public static ConstraintViolation<RequestHandlerDto> CONSTRAINTS = ConstraintViolationImpl
            .forBeanValidation(
                    "messageTemplate",
                    null,
                    null,
                    "Test with Valid Data",
                    RequestHandlerDto.class,
                    null,
                    null,
                    new RequestHandlerDto(),
                    null,
                    null,
                    null
            );

    public static User USER = new User(
            USER_NAME,
            PASSWORD);

    public static UserDetail USER_DETAIL = new UserDetail(
            USER_NAME,
            PHONE_NUMBER,
            ADDRESS);

    public static RequestHandlerDto REQUEST_HANDLER_DTO = new RequestHandlerDto(
            USER_NAME,
            PASSWORD,
            PHONE_NUMBER,
            ADDRESS);
    public static ResponseHandlerDto RESPONSE_HANDLER_DTO = new ResponseHandlerDto(
            USER_NAME,
            PHONE_NUMBER,
            ADDRESS);

}
