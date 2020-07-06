package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.security.AuthenticationRequest;
import it.danieltrosko.lsauto.security.AuthenticationResponse;
import it.danieltrosko.lsauto.security.JwtUtil;
import it.danieltrosko.lsauto.services.MyUserDetailService;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class AuthenticateController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailService userDetailService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthenticateController(AuthenticationManager authenticationManager, MyUserDetailService userDetailService, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthenticationRequest authenticationRequest) {

        if (userService.isEmailAndPasswordCorrect(authenticationRequest.getEmail(),authenticationRequest.getPassword())) {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

            UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());

            final String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }

        return new ResponseEntity<>("Email or password is not correct",HttpStatus.UNAUTHORIZED);


    }
}
