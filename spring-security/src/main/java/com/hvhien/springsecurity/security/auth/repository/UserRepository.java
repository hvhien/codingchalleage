package com.hvhien.springsecurity.security.auth.repository;
import com.hvhien.springsecurity.security.auth.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);

}
