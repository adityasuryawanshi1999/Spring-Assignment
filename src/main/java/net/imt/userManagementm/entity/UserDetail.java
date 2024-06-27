package net.imt.userManagementm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userdetails")
public class UserDetail {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "address", nullable = false)
    private String address;
}
