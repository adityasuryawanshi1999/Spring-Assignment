package net.imt.userManagementm.repository;

import net.imt.userManagementm.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,String> {
}
