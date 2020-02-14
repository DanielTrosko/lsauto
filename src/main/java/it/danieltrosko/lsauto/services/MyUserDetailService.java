package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    private UserService userService;
    private AuthoritiesService authoritiesService;

    public MyUserDetailService(UserService userService, AuthoritiesService authoritiesService) {
        this.userService = userService;
        this.authoritiesService = authoritiesService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDTO userDTO = userService.getUserByEmail(email);
        return new User(userDTO.getEmail(), userDTO.getPassword(), new ArrayList<>());


    }
}
