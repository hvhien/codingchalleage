package com.hvhien.springsecurity.security.auth.service;

import com.hvhien.springsecurity.security.auth.model.CustomeUserDetail;
import com.hvhien.springsecurity.security.auth.model.UserEntity;
import com.hvhien.springsecurity.security.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUsername(username);
    if (null == user) {
      throw new UsernameNotFoundException(username);
    }
    return new CustomeUserDetail(user);
  }

  public UserDetails loadById(Long id){
    Optional<UserEntity> user=userRepository.findById(id);
    if (user.isPresent()){
      return new CustomeUserDetail(user.get());
    }
    return null;
  }
}
