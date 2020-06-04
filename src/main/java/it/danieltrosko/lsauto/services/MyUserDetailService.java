package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

    private UserService userService;


    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDTO userDTO = userService.getUserByEmail(email);
        return new User(userDTO.getEmail(), userDTO.getPassword(), new ArrayList<>());
    }



}
