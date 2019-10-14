package io.github.xpakx.herbarium.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.xpakx.herbarium.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
  Optional<User> findByEmail(String email);
  
  Optional<User> findByUsername(String username);
}
