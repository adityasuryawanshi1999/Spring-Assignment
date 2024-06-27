package net.imt.userManagementm.repository;

import net.imt.userManagementm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//no need to use Transactional and service in service layer
public interface UserRepository extends JpaRepository<User,String> {

}
