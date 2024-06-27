package net.imt.userManagementm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHandlerDto {
    private String username;
    private String phoneNo;
    private String address;
}
