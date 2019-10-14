package io.github.xpakx.herbarium.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.xpakx.herbarium.entity.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, Integer>
{  
  Optional<UserRole> findByName(String username);
}
