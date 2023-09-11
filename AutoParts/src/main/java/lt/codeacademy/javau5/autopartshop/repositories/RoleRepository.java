package lt.codeacademy.javau5.autopartshop.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau5.autopartshop.models.ERole;
import lt.codeacademy.javau5.autopartshop.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}