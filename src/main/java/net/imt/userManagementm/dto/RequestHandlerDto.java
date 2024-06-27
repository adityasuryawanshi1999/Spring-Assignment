package net.imt.userManagementm.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestHandlerDto {
    @NotNull(message = "Username cannot be empty")
    @Size(min = 3, max = 10, message = "Username should be between 3 and 10")
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 3, max = 25, message = "Password should be between 3 and 25")
    private String password;

    @NotNull(message = "Phone number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter valid phone number")
    private String phoneNo;

    @NotNull(message = "Address cannot be empty")
    @Size(min = 3, max = 100, message = "Enter valid address")
    private String address;
}
