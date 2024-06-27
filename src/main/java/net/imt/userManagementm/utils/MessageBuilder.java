package net.imt.userManagementm.utils;

import jakarta.validation.ConstraintViolation;
import net.imt.userManagementm.dto.RequestHandlerDto;

import java.util.Set;

public class MessageBuilder {
    public static String buildBadRequestMessage(Set<ConstraintViolation<RequestHandlerDto>> violations){
        String violationMessage = "";
        for(ConstraintViolation i: violations){
            violationMessage += i.getMessage()+", ";
        }

        return violationMessage.substring(0, violationMessage.length()-2);
    }
}
